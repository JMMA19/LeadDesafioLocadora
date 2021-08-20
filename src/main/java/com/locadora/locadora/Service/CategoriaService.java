package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.locadora.locadora.models.Categoria;
import com.locadora.locadora.repository.CategoriaRepository;

@Service
public class CategoriaService {

@Autowired
CategoriaRepository categoriaRepository;

//Cadastro de Categoria / Atualiza caso passe a Id já cadastrada
public Categoria salvarCategoria(Categoria cat) {
		return categoriaRepository.save(cat);
	}
//listagem de Categoria Geral e por Id ///////////////////////
public List<Categoria> listarCategoria(){
return categoriaRepository.findAll();
	}
public Categoria listarporid(long id){
	 return categoriaRepository.findById(id);
	}

//Deleta Categoria por Id
	public Categoria deletarcategoria(long id){
		return categoriaRepository.deleteById(id);
	}

}
