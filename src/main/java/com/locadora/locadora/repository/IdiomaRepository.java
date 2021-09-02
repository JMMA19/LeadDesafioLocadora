package com.locadora.locadora.repository; 
  import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.locadora.models.Idioma;
 @Repository  *  
 public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
  
  
  
  }
 