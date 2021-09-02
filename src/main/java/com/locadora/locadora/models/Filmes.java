package com.locadora.locadora.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Filme_tb")
public class Filmes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;

	public String Titulo;
	public String Sinopse;
	public String imagem;
	public String Data_lancamento;
	public Double Duracao;

	@ManyToOne
	public Idioma idioma;
	@ManyToOne
	public Categorias categorias;

}