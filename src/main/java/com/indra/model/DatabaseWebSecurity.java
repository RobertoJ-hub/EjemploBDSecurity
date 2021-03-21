package com.indra.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;

	String query="SELECT NOMBREUSUARIO,CLAVE,ACTIVO FROM USUARIOS WHERE NOMBREUSUARIO=?";
	String queryAuth = "SELECT NOMBREUSUARIO, ROL FROM ROLES WHERE NOMBREUSUARIO =?";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query)
		 .authoritiesByUsernameQuery(queryAuth);
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	        .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login-error.html")
	      .and()
	        .logout()
	        .logoutSuccessUrl("/")
	        .and()
	        .authorizeRequests()
	        .antMatchers("static/**", "images/**").permitAll()
	        .antMatchers("/login").permitAll()
	        .antMatchers("/registro").permitAll()
	        .antMatchers("/guardarUsuario").permitAll()
	        //.antMatchers("/logout").permitAll()
	        .antMatchers("/eliminar").hasRole("admin")
	        
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().permitAll();
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/").hasAnyAuthority("admin");
	}*/
}
