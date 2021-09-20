package com.locadora.locadora.Controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locadora.locadora.Models.Perfil;
import com.locadora.locadora.Service.PerfilService;

@Controller
@RequestMapping(value = "/Perfil")
public class PerfilConroller {
	@Autowired
	PerfilService perfilService;

	@PostMapping(value = "/Save")
	public ResponseEntity<?> SalvarPerfil(@RequestBody @Valid List<Perfil> perfil) {
		try {
			return new ResponseEntity<List<Perfil>>(perfilService.savePerfil(perfil), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/sow")
	public ResponseEntity<?> ListarPerfil() {
		try {
			List<Perfil> ListaDeperfil = perfilService.ListarPerfilGeral();
			if (ListaDeperfil.isEmpty()) {
				return new ResponseEntity<String>("Sem Registros de Perfil", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<Perfil>>(ListaDeperfil, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/Delete/{id}")
	public ResponseEntity<?> DeletarPerfil(@PathVariable(value = "id") long id) {
		try {
			return new ResponseEntity<Perfil>(perfilService.DeletaPerfil(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
