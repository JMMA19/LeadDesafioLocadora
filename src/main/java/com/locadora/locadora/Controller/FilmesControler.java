package com.locadora.locadora.Controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.locadora.Models.Filme;
import com.locadora.locadora.Service.FilmesService;

@RestController
@RequestMapping(value = "/Filmes")
public class FilmesControler {

	@Autowired
	FilmesService FilmeService;

	@PostMapping("/save")//Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
	public ResponseEntity<?> Salvarfilme(@RequestBody @Valid Filme filme) {
        	 try {
        		 if(filme.categoria == null || filme.idioma == null ) {
        			 return new ResponseEntity<String>("Categoria ou Idioma não preenchido.", HttpStatus.BAD_REQUEST);
        		 }else {
        			 return new ResponseEntity<Filme>(filme, HttpStatus.OK);
				}
			} catch (Exception e) {
				return new ResponseEntity<String>("Erro ao cadastrar", HttpStatus.BAD_REQUEST);
			}
	}

	@GetMapping("/show") // listagem de Filmes
	public ResponseEntity<?> listarfilmes() {
		try {
			List<Filme> FilmeAll = FilmeService.listarfilmes();
			if (FilmeAll.isEmpty()) {
				return new ResponseEntity<String>("Sem Registros", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<Filme>>(FilmeAll, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/show/{id}") // listagem de Filmes por ID
	public ResponseEntity<?> listarporid(@PathVariable(value = "id") long id) {

		try {
			Optional<Filme> FilmePorID = FilmeService.listarporid(id);
			if (FilmePorID.isEmpty()) {
				return new ResponseEntity<String>("Sem Registros com essa Id = " + id, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Optional<Filme>>(FilmePorID,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/showTit/{titulo}") // listagem de Filmes por Titulo
	public ResponseEntity<?> listarportitulo(@PathVariable(value = "titulo") String titulo) {
		if (titulo == null) {
			return new ResponseEntity<String>("campo Categoria não foi preenchido", HttpStatus.BAD_REQUEST);
		} else {
			try {
				List<Filme> Lista = FilmeService.findByTitulo(titulo);
				if(Lista.isEmpty()) {
					return new ResponseEntity<String>("Sem Registros com esse Titulo => = " + titulo, HttpStatus.NOT_FOUND);
					
				}else {
					return new ResponseEntity<List<Filme>>(Lista, HttpStatus.OK);
				}
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
	}

	@GetMapping("/showCat/{tag}")// listagem de Filmes por Categoria
	public ResponseEntity<?> listarporCategoria(@PathVariable(value = "tag") String tag) {
			try {
				List<Filme> Lista = FilmeService.listarporCategoria(tag);
				if (Lista.isEmpty()) {
					return new ResponseEntity<String>("Sem Registros com essa Categoria => = " + tag, HttpStatus.BAD_REQUEST);
				}else {
					return new ResponseEntity<List<Filme>>(Lista, HttpStatus.OK);
				}
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}

	@PostMapping("/del/{id}") // Deleta Filmes por Id
	public ResponseEntity<?> deletarfilme(@PathVariable(value = "id") long id) {
		try {
			return new ResponseEntity<Filme>(FilmeService.deletarfilme(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
