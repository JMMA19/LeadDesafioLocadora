package com.locadora.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadora.models.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long> {
	Autor findById(long id);

	Autor deleteById(long id);
}
