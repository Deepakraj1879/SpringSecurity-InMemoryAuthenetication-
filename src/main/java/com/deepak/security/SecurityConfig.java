package com.deepak.security;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home","/detail","/contact").permitAll()
		.requestMatchers("/statement","/balance").hasRole("USER")
		.requestMatchers("/loan").hasRole("ADMIN")
	  
		//.authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		
		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService detailService()
	{
		UserDetails user=User.withUsername("deepak").password(passwordEncoder().encode("1234")).roles("USER").build();
				System.out.println(user);
		UserDetails admin=User.withUsername("admin").password(passwordEncoder().encode("12345")).roles("ADMIN").build();
		      System.out.println(admin);
		      
		      return new  InMemoryUserDetailsManager(user,admin);
	}
	

}
