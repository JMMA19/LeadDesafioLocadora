package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.locadora.locadora.models.Categorias;
import com.locadora.locadora.repository.CategoriasRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriasRepository categoriaRepo;

//Cadastro de Categoria / Atualiza caso passe a Id já cadastrada
	public Categorias salvarCategoria(Categorias cat) {
		return categoriaRepo.save(cat);
	}

//listagem de Categoria Geral e por Id ///////////////////////
	public List<Categorias> listarCategoria() {
		return categoriaRepo.findAll();
	}

	public Categorias listarporid(long id) {
		return categoriaRepo.findById(id);
	}

//Deleta Categoria por Id
	public Categorias deletarcategoria(long id) {
		return categoriaRepo.deleteById(id);
	}

}
