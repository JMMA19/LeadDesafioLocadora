package com.locadora.locadora.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Service.CategoriaService;

@RestController
@RequestMapping(value = "/Categoria")
public class CategoriaControler {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping("/save")
	public ResponseEntity<?> CadastroCategoria(@RequestBody Categoria cat) {
		try {
			return new ResponseEntity<Categoria>(categoriaService.salvarCategoria(cat), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/show")
	public ResponseEntity<?> ListaCategoria() {
		try {
			List<Categoria> Listagem = categoriaService.listarCategoria();
			if (Listagem.isEmpty()) {
				return new ResponseEntity<String>("Sem registros!", HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Categoria>>(Listagem, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<?> listarporid(@PathVariable(value = "id") long id) {
		try {
			Categoria Listagem = categoriaService.listarporid(id);
			if (Listagem != null) {
				return new ResponseEntity<Categoria>(Listagem, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Sem registros com essa ID " + id, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/showTag/{tag}")
	public ResponseEntity<?> listarporid(@PathVariable(value = "tag") String tag) {
		try {
			Categoria Listagem = categoriaService.findByTag(tag);
			if (Listagem != null) {
				return new ResponseEntity<Categoria>(Listagem, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Sem registros com essa Tag " + tag, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
