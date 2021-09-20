package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Repository.UsuarioRepository;

@Service
public class UsuarioService {
@Autowired
UsuarioRepository userRepository;
@Autowired
PerfilService perfilService;

public Usuario SalvarUser(Usuario user) {
	perfilService.savePerfil(user.Perfil);
	user.Senha = new BCryptPasswordEncoder().encode(user.Senha); //cripografando a senha para salvar em banco.
	return userRepository.save(user);
}
public List<Usuario> FindAll(){
	return userRepository.findAll();
}
}
