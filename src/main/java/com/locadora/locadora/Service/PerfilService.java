package com.locadora.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.locadora.Models.Perfil;
import com.locadora.locadora.Repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilService;

	public List<Perfil> savePerfil(List<Perfil> perfil) {
		List<Perfil> perfisList = (List<Perfil>) perfilService.saveAll(perfil);
		return perfisList;
	}
}
