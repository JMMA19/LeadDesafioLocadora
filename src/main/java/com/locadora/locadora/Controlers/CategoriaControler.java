package com.locadora.locadora.Controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.locadora.Service.CategoriaService;
import com.locadora.locadora.models.Categorias;

@RestController
@RequestMapping(value = "/Categoria")
public class CategoriaControler {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping("/save")
	public Categorias CadastroCategoria(@RequestBody Categorias cat) {
		return categoriaService.salvarCategoria(cat);

	}
	
	@GetMapping("/show")
	public List<Categorias> ListaCategoria() {
		return categoriaService.listarCategoria();

	}

	@GetMapping("/show/{id}")
	public Categorias listarporid(@PathVariable(value = "id") long id) {
		return categoriaService.listarporid(id);
	}

}
