package com.locadora.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.locadora.locadora.models.Filme;

public interface FilmeReposiory extends JpaRepository<Filme, Long>{
Filme findById(long id);

Filme deleteById(long id);
}
