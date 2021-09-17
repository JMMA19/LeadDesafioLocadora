package com.locadora.locadora.SecurityConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.locadora.locadora.Repository.UsuarioRepository;


@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	 private UsuarioRepository userRepository;

	@Autowired
	InplementsUserDetailsService inpUser;
	
	@Autowired
	 private TokenServices tokenServices;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	//autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inpUser).passwordEncoder(new BCryptPasswordEncoder());
	}

	// autorizções
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/Filmes/").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/Filmes/showid").permitAll()
			    .antMatchers(HttpMethod.POST,"/Auth").permitAll() 
				.anyRequest().authenticated() // obriga a autenticar user
				.and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(new FiltroDeAutentiacaoPotToken(tokenServices, userRepository), UsernamePasswordAuthenticationFilter.class);
	}

}
