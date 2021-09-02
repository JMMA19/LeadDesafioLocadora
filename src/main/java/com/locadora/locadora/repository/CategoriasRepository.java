package com.locadora.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadora.models.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

	Categorias findById(long id);

	Categorias deleteById(long id);

}
