package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	//public ResponseEntity<List<Filme>> findByTitulo(@RequestParam String Titulo) {
		//return new ResponseEntity<List<Filme>>(FilmeRepo.findByTitulo(Titulo), HttpStatus.OK);
	//}
	// listagem de Filmes por Id
	public Filme listarporid(long id) {
		return FilmeRepo.findById(id);
	}


	/*
	 * @ResponseBody public ResponseEntity<List<Filmes>> listarporCategorias(
	 * Categorias categorias) { List<Filmes> filme =
	 * FilmeRepo.findByCat(categorias);
	 * 
	 * //return new ResponseEntity <List<Filmes>>(filme, HttpStatus.OK); }
	 */

	// Deleta Filmes por Id e Geral
	public Filme deletarfilme(long id) {
		return FilmeRepo.deleteById(id);
	}

	/*
	 * deleta todos os dados da tabela.
	 * 
	 * @GetMapping("/deletarall") public void deletatodosfilmes(){
	 * FilmeRepository.deleteAll();}
	 */
}
