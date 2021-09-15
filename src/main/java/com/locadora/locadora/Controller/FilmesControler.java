package com.locadora.locadora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Service.FilmesService;

@RestController
@RequestMapping(value = "/Filmes")
public class FilmesControler {

	@Autowired
	FilmesService FilmeService;


//Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	@PostMapping("/save")
		public ResponseEntity<Filme> Salvarfilme(@RequestBody Filme filme) {
		return FilmeService.salvarFilme(filme);

	}

//listagem de Filmes Geral e por Id ///////////////////////
	@GetMapping("/show")
	public List<Filme> listarfilmes() {
		return FilmeService.listarfilmes();
	}

	@GetMapping("/show/{id}")
	public Filme listarporid(@PathVariable(value = "id") long id) {
		return FilmeService.listarporid(id);
	}
	
	@GetMapping("/showTitulo/{titulo}")
	
//	public ResponseEntity<List<Filme>> listarportitulo(@PathVariable (value = "titulo") String titulo) {		
//		return FilmeService.findByTitulo(titulo);
//	}
	
//@GetMapping("/showCategoria/{categorias}")
	
	//public ResponseEntity<List<Filmes>> listarportitulo(@PathVariable (value = "categorias") Categorias categorias) {		
	//	return FilmeService.listarporCategorias(categorias);
	//}
	



//Deleta Filmes por Id e Geral  ///////////////////////
	@PostMapping("/del/{id}")
	public Filme deletarfilme(@PathVariable(value = "id") long id) {
		return FilmeService.deletarfilme(id);
	}
//deleta todos os dados da tabela.
//@GetMapping("/deletarall")    
//public void deletatodosfilmes(){
//FilmeRepository.deleteAll();}
}
