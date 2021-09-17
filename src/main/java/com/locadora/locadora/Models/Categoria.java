package com.locadora.locadora.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categoria_TB")
@Getter
@Setter
@AllArgsConstructor
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;
	
	@NotBlank(message = "Toda Categoria precisa de um Nome")
	public String Nome;
	
	@NotBlank(message = "Toda Categoria precisa de uma Tag")
	public String Tag;
	
	//public String Idioma;

}
