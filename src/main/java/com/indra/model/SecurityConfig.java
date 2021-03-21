package com.indra.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.indra.service.UsersService;

public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/{
	
	//@Autowired
	//private UsersService uS;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private DataSource dataSource;
	
	String query = "SELECTED USERNAME, PASWORD, ENABLED FROM USERS WHERE USERNAME=?";
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception{
			//auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query);
			auth.userDetailsService(uS).passwordEncoder(bcrypt);
	}
		
	
	@Override
	protected void configure (HttpSecurity http ) throws Exception{
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}*/
}