package com.locadora.locadora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadora.Models.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	Categoria findById(long id);

	Categoria deleteById(long id);

}
