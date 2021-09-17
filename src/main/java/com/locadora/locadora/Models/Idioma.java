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
@Table(name = "Idiomas_TB")
@Getter
@Setter
@AllArgsConstructor
public class Idioma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long ID;

	@NotBlank(message = "Todos os Idiomas precisam de um Nome")
	public String Nome;
	@NotBlank(message = "Todos os Idiomas precisam de uma TAG")
	public String Tag;

}
