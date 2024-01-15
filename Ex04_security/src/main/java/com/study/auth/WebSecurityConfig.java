package com.study.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 람다형태 : request -> request (security 7.0부터 람다식만 가능한걸로 바뀜)
		http.csrf((csrf)-> csrf.disable())
			.cors((cors)-> cors.disable())
			.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()	
		);
		
		// 스프링부트에서 제공해주는 login폼 사용
		/*
		http.formLogin((formLogin)->
						formLogin.permitAll());
		
		*/
		// 내가 만든 login 폼 사용하기

		http.formLogin((formLogin)-> formLogin
							.loginPage("/loginForm")	// 로그인폼 url(default : /login)
							.loginProcessingUrl("/login_check")	// action에 넣은 url
							.usernameParameter("username") // 기본값(j_username)
							.passwordParameter("password") // 기본값(j_password)
							.permitAll());

		http.logout((logout)-> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
							   .username("user")
							   .password(pEncoder().encode("1234"))
							   .roles("USER")
							   .build();
		
		UserDetails admin = User.builder()
				   .username("admin")
				   .password(pEncoder().encode("1234"))
				   .roles("USER", "ADMIN")
				   .build();
		
		// 메모리에 사용자 정보를 담는다
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	public PasswordEncoder pEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
