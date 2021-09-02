package com.locadora.locadora.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.locadora.locadora.models.Categorias;
import com.locadora.locadora.models.Filmes;
import com.locadora.locadora.models.Idioma;

public interface FilmesReposiory extends JpaRepository<Filmes, Long> {

	@Query(value = "select T from Filmes T where T.Titulo like %?1%")
	List<Filmes> findByTitulo(String Titulos);

	Filmes findById(long id);

	Filmes deleteById(long id);

	Filmes save(Idioma idiomas);

	Filmes save(Categorias categorias);

	// @Query(value = "select c from Filmes cat where c.categorias like %?1%")
	// List<Filmes> findByCat(Categorias categorias);

}
