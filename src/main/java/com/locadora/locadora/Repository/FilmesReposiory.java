package com.locadora.locadora.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Models.Idioma;

public interface FilmesReposiory extends JpaRepository<Filme, Long> {

	//@Query(value = "select T from Filmes T where T.Titulo like %?1%")
	//List<Filme> findByTitulo(String Titulos);

	Filme findById(long id);

	Filme deleteById(long id);

	Filme save(Idioma idiomas);

	Filme save(Categoria categorias);

	// @Query(value = "select c from Filmes cat where c.categorias like %?1%")
	// List<Filmes> findByCat(Categorias categorias);

}
