package com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sandeep").password("{noop}1234").roles("admin")
		.and()
		.withUser("virat").password("{noop}4321").roles("user");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/helloworld").authenticated()
		.antMatchers("/hello").permitAll()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/process-login").permitAll() 
		.and()
		.httpBasic().and().logout();
	}

}
