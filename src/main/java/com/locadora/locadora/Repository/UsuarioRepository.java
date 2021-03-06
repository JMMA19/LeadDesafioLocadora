package com.locadora.locadora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.locadora.Models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findById(long id);
	public Usuario findByCPF(String CPF);
	Usuario deleteById(long id);
	
}
