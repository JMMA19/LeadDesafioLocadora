package com.locadora.locadora.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadora.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findById(long id);

	Categoria deleteById(long id);
			
	
}
