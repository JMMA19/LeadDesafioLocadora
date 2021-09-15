package com.locadora.locadora.SecurityConfig;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.locadora.locadora.Models.Usuario;
import com.locadora.locadora.Repository.UsuarioRepository;

public class FiltroDeAutentiacaoPotToken extends OncePerRequestFilter {

//filtros não permitem fazer a injeção por @autowired, então preciso trazer as dependencias de TokenServices por construtor.
	private TokenServices TokenServices;
	private UsuarioRepository userRepository;

	public FiltroDeAutentiacaoPotToken(TokenServices TokenServices, UsuarioRepository userRepository) {
		super();
		this.TokenServices = TokenServices;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String Token = RecuperarToken(request);
		boolean isValid = TokenServices.Autenticatoken(Token);
		if (isValid) {
			autenticarUser(Token);
		}
		System.out.println(isValid);
		filterChain.doFilter(request, response);
	}

	private void autenticarUser(String token) {
		Long IdRecuperado = TokenServices.getIdUsuario(token);
		Usuario usuario = userRepository.findById(IdRecuperado).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null,
				usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		System.out.println(usuario.getUsername()  +  usuario.getAuthorities());
		
	}

	private String RecuperarToken(HttpServletRequest request) {
		String Token = request.getHeader("Authorization");
		if (Token == null || Token.isEmpty() || !Token.startsWith("Bearer")) {
			return null;
		}
		return Token.substring(7, Token.length());
	}

}
