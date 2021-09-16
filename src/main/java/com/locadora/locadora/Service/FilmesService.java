package com.locadora.locadora.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Repository.FilmesReposiory;

@Service
public class FilmesService {

	@Autowired
	FilmesReposiory FilmeRepo;
	@Autowired
	CategoriaService Categoriaservice;
	@Autowired
	IdiomasService IdiomaService;

	// Cadastro de Filmes / Atualiza caso passe a Id já cadastrada public Filmes
	public Filme salvarFilme(Filme filme) {
		if (filme.categorias != null && filme.idioma != null) { // salva tanto categoria quanto idioma no banco.
			Categoriaservice.salvarCategoria(filme.categorias);
			IdiomaService.SalvarIdioma(filme.idioma);
		}
		return FilmeRepo.save(filme);
	}

	// listagem de Filmes Geral
	public List<Filme> listarfilmes() {
		return FilmeRepo.findAll();
	}
	// listagem de Filmes por titulo
	public ResponseEntity<List<Filme>> findByTitulo(@RequestParam String Titulo) {
	return new ResponseEntity<List<Filme>>(FilmeRepo.findByTitulo(Titulo), HttpStatus.OK);
	}
	// listagem de Filmes por Categoria
		public Optional<Filme> listarporCategoria(@RequestParam String tag) {
			Categoria CategoriaPorTag = Categoriaservice.findByTag(tag);
			Long Idcat = CategoriaPorTag.Id;
		    Optional<Filme> pqp = FilmeRepo.findByCat(Idcat);
			return  (pqp);
		}
	// listagem de Filmes por Id
	public Optional<Filme> listarporid(long id) {
		Optional<Filme> F = FilmeRepo.findById(id);
		return F;
	}


	
 

	// Deleta Filmes por Id e Geral
	public Filme deletarfilme(long id) {
		return FilmeRepo.deleteById(id);
	}

}