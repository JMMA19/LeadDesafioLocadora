package com.locadora.locadora.SecurityConfig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServices {
	@Value("${config.jwt.expiracao}")
	private String expiracao;
	@Value("${config.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario Logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date ExpiraSession = new Date(hoje.getTime() + Long.parseLong(expiracao));
		return Jwts.builder()
				.setIssuer("user Logado")
				.setSubject(Logado.getIdUser().toString())
				.setIssuedAt(hoje)
				.setExpiration(ExpiraSession)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}
}
