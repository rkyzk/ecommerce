package com.api.ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public CorsFilter corsFilter() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
	    config.setAllowCredentials(true);
	    config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
	    config.addAllowedHeader("*");
	    config.addExposedHeader("Set-Cookie");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 return http
				  .csrf(AbstractHttpConfigurer::disable)
                  .authorizeHttpRequests(auth -> {
		    	    auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
		    	    auth.requestMatchers(HttpMethod.GET, "/api/1.0/**").permitAll();
		            auth.requestMatchers(HttpMethod.POST, "/api/1.0/signup/").permitAll();
		            auth.anyRequest().authenticated();
		    } 
		).build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
