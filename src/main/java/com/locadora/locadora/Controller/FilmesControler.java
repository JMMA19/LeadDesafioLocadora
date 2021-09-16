package com.locadora.locadora.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Service.FilmesService;


@RestController
@RequestMapping(value = "/Filmes")
public class FilmesControler {

	@Autowired
	FilmesService FilmeService;

//Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	@PostMapping("/save")
	public Filme Salvarfilme(@RequestBody Filme filme) {

	 return FilmeService.salvarFilme(filme);

	 }

//listagem de Filmes Geral e por Id ///////////////////////
	@GetMapping("/show")
	public List<Filme> listarfilmes() {
		return FilmeService.listarfilmes();
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<?> listarporid(@PathVariable(value = "id") long id) {			
		
		try {
			Optional<Filme> FilmePorID = FilmeService.listarporid(id);
			if (FilmePorID.isPresent()) {
				return new ResponseEntity<Optional<Filme>>(FilmePorID, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Sem Registros com essa Id = "+id,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

@GetMapping("/showTitulo/{titulo}")

	public ResponseEntity<List<Filme>> listarportitulo(@PathVariable (value = "titulo") String titulo) {
	
		return FilmeService.findByTitulo(titulo);
	}

@GetMapping("/showCategoria/{tag}")

	 public  Optional<Filme> listarporCategoria(@PathVariable (value = "tag") String tag) {
	 return FilmeService.listarporCategoria(tag);
	 }

//Deleta Filmes por Id e Geral  ///////////////////////
	@PostMapping("/del/{id}")
	public Filme deletarfilme(@PathVariable(value = "id") long id) {
		return FilmeService.deletarfilme(id);
	}
}
