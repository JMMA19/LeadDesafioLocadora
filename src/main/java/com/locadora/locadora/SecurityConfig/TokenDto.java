package com.locadora.locadora.SecurityConfig;

public class TokenDto {
private String Token;
private String Tipo;

	public TokenDto(String Token, String Tipo) {
		this.Token = Token;
		this.Tipo = Tipo;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}  

}
