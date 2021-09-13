package com.locadora.locadora.SecurityConfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class FiltroDeAutentiacaoPotToken extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String Token = RecuperarToken(request);
		System.out.println(Token);
		filterChain.doFilter(request, response);
	}

	private String RecuperarToken(HttpServletRequest request) {
		String Token = request.getHeader("Authorization");
		if (Token == null || Token.isEmpty() || !Token.startsWith("Bearer")) {
			return null;
		}
		return Token.substring(7, Token.length());
	}

}
