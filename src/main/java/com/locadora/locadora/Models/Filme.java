package com.locadora.locadora.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Filme_tb")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long Id;

	@NotBlank(message = "Todo Filme precisa ter um Titulo")
	public String Titulo;

	@NotBlank(message = "Todo Filme precisa ter uma Sinopse")
	public String Sinopse;

	@NotBlank(message = "Todo Filme precisa ter uma Imagem")
	public String imagem;

	@Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{4}\\", message = "O formato de duração precisa ser dia.mês.ano")
	@NotNull(message = "Todos os filmes precisam de Data De Lançamento")
	public Date Data_lancamento;

	@Digits(integer = 5, fraction = 2)
	@Pattern(regexp = "\\d{2}\\.\\d{2}\\", message = "O formato de duração precisa ser h.m")
	public Double Duracao;

	@NotNull(message = "Todos os filmes precisam de idiioma")
	@ManyToOne
	public Idioma idioma;

	@NotNull(message = "Todos os filmes precisam de Categoria")
	@ManyToOne
	public Categoria categoria;

}