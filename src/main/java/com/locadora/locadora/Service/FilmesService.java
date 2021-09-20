package com.locadora.locadora.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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
		Categoriaservice.salvarCategoria(filme.categoria);
		IdiomaService.SalvarIdioma(filme.idioma);
		return FilmeRepo.save(filme);
	}

	// listagem de Filmes Geral
	public List<Filme> listarfilmes() {
		return FilmeRepo.findAll();
	}

	// listagem de Filmes por titulo
	public List<Filme> findByTitulo(@RequestParam String Titulo) {
		return FilmeRepo.findByTitulo(Titulo);
	}

	// listagem de Filmes por Categoria
	public List<Filme> listarporCategoria(@RequestParam String tag) {
		Categoria categoria = Categoriaservice.findByTag(tag);
		return FilmeRepo.findByCategoria(categoria);
	}

	// listagem de Filmes por Id
	public Optional<Filme> listarporid(long id) {
		return FilmeRepo.findById(id);
	}

	// Deleta Filmes por Id
	public Filme deletarfilme(long id) {
			return FilmeRepo.deleteById(id);
	}
}