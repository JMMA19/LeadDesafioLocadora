package com.locadora.locadora.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Service.UsuarioService;

@RestController
@RequestMapping(value = "/User")
public class UsuarioController {

	@Autowired
	UsuarioService userService;


	@PostMapping("/save") // Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	public ResponseEntity<?> salvarUser(@RequestBody @Valid Usuario user) {
		try {
			return new ResponseEntity<Usuario>(userService.SalvarUser(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/show") // listagem de Filmes
	public ResponseEntity<?> listUser() {
		try {
			List<Usuario> Lista = userService.FindAll();
			if (Lista.isEmpty()) {
				return new ResponseEntity<String>("Sem Registros!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Usuario>>(Lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
