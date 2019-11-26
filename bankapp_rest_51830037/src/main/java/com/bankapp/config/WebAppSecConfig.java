package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebAppSecConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
  private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		//super.configure(auth);
	}

	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//super.configure(http);
		http.httpBasic().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/user/**").hasAnyRole("ADMIN")
		.antMatchers("/api/account/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/api/transaction/**").hasAnyRole("ADMIN","MGR","CLERK")
		.antMatchers("/home/**").authenticated();
	}

	
}
