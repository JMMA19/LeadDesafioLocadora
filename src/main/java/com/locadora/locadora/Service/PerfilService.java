package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.locadora.locadora.Models.Perfil;
import com.locadora.locadora.Repository.PerfilRepository;


@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> savePerfil( List<Perfil> perfil) {
		return perfilRepository.saveAll(perfil);
	}
	
	public  List<Perfil> ListarPerfilGeral() {
	return perfilRepository.findAll();
	}
	
	public Perfil DeletaPerfil(long id) {
		return perfilRepository.deleteById(id);
	}
}
