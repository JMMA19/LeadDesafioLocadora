package com.locadora.locadora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Categoria CadastroCategoria(@RequestBody Categoria cat) {
		return categoriaService.salvarCategoria(cat);

	}
	
	@GetMapping("/show")
	public List<Categoria> ListaCategoria() {
		return categoriaService.listarCategoria();

	}

	@GetMapping("/show/{id}")
	public Categoria listarporid(@PathVariable(value = "id") long id) {
		return categoriaService.listarporid(id);
	}
	@GetMapping("/showTag/{tag}")
	public Categoria listarporid(@PathVariable(value = "tag") String tag) {
		return categoriaService.findByTag(tag);
	}
}
