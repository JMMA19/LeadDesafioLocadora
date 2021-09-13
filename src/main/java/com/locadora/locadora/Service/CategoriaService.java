package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Categoria;
import com.locadora.locadora.Repository.CategoriasRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriasRepository categoriaRepo;

//Cadastro de Categoria / Atualiza caso passe a Id já cadastrada
	public Categoria salvarCategoria(Categoria cat) {
		return categoriaRepo.save(cat);
	}

//listagem de Categoria Geral e por Id ///////////////////////
	public List<Categoria> listarCategoria() {
		return categoriaRepo.findAll();
	}

	public Categoria listarporid(long id) {
		return categoriaRepo.findById(id);
	}

//Deleta Categoria por Id
	public Categoria deletarcategoria(long id) {
		return categoriaRepo.deleteById(id);
	}

}
