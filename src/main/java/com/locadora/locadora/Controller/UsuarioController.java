package com.locadora.locadora.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Service.PerfilService;
import com.locadora.locadora.Service.UsuarioService;

@RestController
@RequestMapping(value = "/User")
public class UsuarioController {

	@Autowired
	UsuarioService userService;
	@Autowired
	PerfilService perfilService;

	@PostMapping("/save") // Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	public Usuario salvarUser(@RequestBody @Valid Usuario user) {
		perfilService.savePerfil(user.Perfil);
		return userService.SalvarUser(user);

	}
	
	@GetMapping("/show") // listagem de Filmes
	public List<Usuario> listUser() {
		return userService.FindAll();
	}
}
