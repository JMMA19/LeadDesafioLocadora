package com.locadora.locadora.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	public String Nome;

	public String CPF;

	public int Telefone;

	public String Email;

	public String Senha;

	public String Idioma;
	
	@ManyToOne
	public Collection<? extends GrantedAuthority> Perfil;

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
