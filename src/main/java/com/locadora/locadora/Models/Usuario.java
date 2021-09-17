package com.locadora.locadora.Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuarios_TB")
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long IdUser;

	@NotBlank(message = "Todo os Usuarios precisam de um Nome")
	public String Nome;
	
	@NotBlank(message = "Todo os Usuarios precisam de um CPF")
	@Size(max = 14, min = 1)
	public String CPF;
	
	@NotBlank(message = "Todo os Usuarios precisam de um Telefone")
	public int Telefone;
	
	@NotBlank(message = "Todo os Usuarios precisam de um Email")
	public String Email;
	
	@NotBlank(message = "Todo os Usuarios precisam de uma Senha")
	@Size(max = 255, min = 3)
	public String Senha;
	
	@NotNull(message = "Todos os usuarios precisam de idiioma")
	@ManyToOne
	public Idioma idioma;
	
	@NotNull(message = "Todos os usuarios precisam de Perfil")
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Perfil> Perfil;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.Perfil;
	}

	@Override
	public String getPassword() {
		return this.Senha;
	}

	@Override
	public String getUsername() {
		return this.CPF;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getIdUser() {
		return IdUser;
	}

	public void setIdUser(Long IdUser) {
		this.IdUser = IdUser;
	}

}