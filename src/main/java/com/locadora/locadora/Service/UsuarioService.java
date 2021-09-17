package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Repository.UsuarioRepository;

@Service
public class UsuarioService {
@Autowired
UsuarioRepository userRepository;

public Usuario SalvarUser(Usuario User) {
	Usuario ObjetoUser = userRepository.save(User);
	return ObjetoUser;
}
public List<Usuario> FindAll(){
	return userRepository.findAll();
}
}
