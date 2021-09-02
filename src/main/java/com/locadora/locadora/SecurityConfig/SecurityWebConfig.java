package com.locadora.locadora.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
@Autowired
InplementsUserDetailsService inpUser;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/Filmes").permitAll()
		/*      Testar sem precisar Logar
		.antMatchers(HttpMethod.GET, "/Filmes/show").permitAll()
		.antMatchers(HttpMethod.GET, "/Filmes/show/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/Filmes/showTitulo/{titulo}").permitAll()
		.antMatchers(HttpMethod.GET, "/Categoria/show").permitAll()
		*/
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(inpUser)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
