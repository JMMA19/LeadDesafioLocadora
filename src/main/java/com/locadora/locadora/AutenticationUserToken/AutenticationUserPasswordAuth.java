package com.locadora.locadora.AutenticationUserToken;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;


public class AutenticationUserPasswordAuth {
@Getter	@Setter
private String CPF;
@Getter	@Setter
private String Senha;
public String getCPF() {
	return CPF;
}
public void setCPF(String CPF) {
	this.CPF = CPF;
}
public String getSenha() {
	return Senha;
}
public void setSenha(String Senha) {
	this.Senha = Senha;
}
public UsernamePasswordAuthenticationToken converteCredenciais() {
	return new UsernamePasswordAuthenticationToken(CPF , Senha);
}

}
