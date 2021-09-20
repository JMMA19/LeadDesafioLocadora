package com.locadora.locadora.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.AutenticationUserToken.AutenticationUserPasswordAuth;
import com.locadora.locadora.SecurityConfig.TokenDto;
import com.locadora.locadora.SecurityConfig.TokenServices;

@RestController
@RequestMapping("/Auth")
public class AutenticacaoController {
@Autowired
private AuthenticationManager authManager;
@Autowired
private TokenServices elson;

 	@PostMapping
	public ResponseEntity<TokenDto> autenticarUser(@RequestBody @Valid AutenticationUserPasswordAuth form) {
		UsernamePasswordAuthenticationToken dadosAutenticacao =  form.converteCredenciais();
		try {
			Authentication authentication = authManager.authenticate(dadosAutenticacao);
			String Token = elson.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(Token, "Bearer"));
		} catch (AuthenticationException e) {
		 return ResponseEntity.badRequest().build();
		}
		
	} 
	
}
