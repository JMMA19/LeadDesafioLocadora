package com.locadora.locadora.Controlers;

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
import com.locadora.locadora.Service.FilmesService;
import com.locadora.locadora.models.Categorias;
import com.locadora.locadora.models.Filmes;

@RestController
@RequestMapping(value = "/Filmes")
public class FilmesControler {

	@Autowired
	FilmesService FilmeService;


//Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	@PostMapping("/save")
		public Filmes Salvarfilme(@RequestBody Filmes filme) {
		return FilmeService.salvarFilme(filme);

	}

//listagem de Filmes Geral e por Id ///////////////////////
	@GetMapping("/show")
	public List<Filmes> listarfilmes() {
		return FilmeService.listarfilmes();
	}

	@GetMapping("/show/{id}")
	public Filmes listarporid(@PathVariable(value = "id") long id) {
		return FilmeService.listarporid(id);
	}
	
	@GetMapping("/showTitulo/{titulo}")
	
	public ResponseEntity<List<Filmes>> listarportitulo(@PathVariable (value = "titulo") String titulo) {		
		return FilmeService.findByTitulo(titulo);
	}
	
//@GetMapping("/showCategoria/{categorias}")
	
	//public ResponseEntity<List<Filmes>> listarportitulo(@PathVariable (value = "categorias") Categorias categorias) {		
	//	return FilmeService.listarporCategorias(categorias);
	//}
	



//Deleta Filmes por Id e Geral  ///////////////////////
	@PostMapping("/del/{id}")
	public Filmes deletarfilme(@PathVariable(value = "id") long id) {
		return FilmeService.deletarfilme(id);
	}
//deleta todos os dados da tabela.
//@GetMapping("/deletarall")    
//public void deletatodosfilmes(){
//FilmeRepository.deleteAll();}
}
