package com.locadora.locadora.Repository; 
  import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.locadora.Models.Idioma;
 @Repository    
 public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
  
  
  
  }
 