package com.locadora.locadora.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Models.Idioma;

public interface FilmesReposiory extends JpaRepository<Filme, Long> {

	@Query(value = "select T from Filme T where T.Titulo like %?1%")
	List<Filme> findByTitulo(String Titulos);

	Optional<Filme> findById(long id);

	Filme deleteById(long id);

	Filme save(Idioma idiomas);

	Filme save(Categoria categoria);
	
	List<Filme> findByCategoria(Categoria categoria);
	
	 
}
