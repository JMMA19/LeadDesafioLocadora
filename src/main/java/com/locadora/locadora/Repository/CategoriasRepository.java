package com.locadora.locadora.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locadora.locadora.Models.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	Categoria findById(long id);

	Categoria deleteById(long id);
	
	@Query(value = "select t from Categoria t where t.Tag like ?1")
	Categoria findByTag(String Tag);

}
