package com.locadora.locadora.Controlers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadora.Service.AutorService;
import com.locadora.locadora.Service.FilmeService;
import com.locadora.locadora.models.Autor;
import com.locadora.locadora.models.Filme;

@RestController
@RequestMapping(value = "/FilmeAPI")
public class FilmeControler {
	
@Autowired
FilmeService FilmeService;
@Autowired
AutorService AutorService;

//Cadastro de Filmes / Atualiza caso passe a Id já cadastrada
@PostMapping("/salvarfilme")
	
public Autor Salvarfilme(@RequestBody   Autor autor ,Filme fil) {
	FilmeService.salvarFilme(fil);
	return AutorService.salvarAutor(autor); 
	
}

//listagem de Filmes Geral e por Id ///////////////////////
@GetMapping("/Listar")
public List<Filme> listarfilmes(){
 return FilmeService.listarfilmes();
}
@GetMapping("/Listar/{id}")
public Filme listarporid(@PathVariable(value = "id" ) long id){
 return FilmeService.listarporid(id);
}


//Deleta Filmes por Id e Geral  ///////////////////////
@PostMapping("/deletefilme/{id}")
public Filme deletarfilme(@PathVariable(value = "id" ) long id){
	return FilmeService.deletarfilme(id);
}
//deleta todos os dados da tabela.
//@GetMapping("/deletarall")    
//public void deletatodosfilmes(){
//FilmeRepository.deleteAll();}
}
