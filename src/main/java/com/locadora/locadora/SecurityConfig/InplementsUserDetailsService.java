package com.locadora.locadora.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Repository.UsuarioRepository;
@Repository 
public class InplementsUserDetailsService implements UserDetailsService{
	@Autowired
	UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String CPF) throws UsernameNotFoundException {
		
		Usuario usuario = userRepository.findByCPF(CPF);
		if(usuario == null) {
			throw new UsernameNotFoundException("Perdoe, mas não foi possivel encontrar usuario.");
		}
		
		return (UserDetails) usuario;
	}

}
