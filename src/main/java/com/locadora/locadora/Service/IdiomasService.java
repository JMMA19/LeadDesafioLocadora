
  package com.locadora.locadora.Service;
 
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Idioma;
import com.locadora.locadora.Repository.IdiomaRepository;
 
  @Service public class IdiomasService {
  
  @Autowired 
  IdiomaRepository IdiomaRepo;
  
  //Cadastro de Idioma / Atualiza caso passe a Id já cadastrada public Idioma
  public Idioma SalvarIdioma(Idioma idiomas) {
	 return IdiomaRepo.save(idiomas); }
  
 }
 