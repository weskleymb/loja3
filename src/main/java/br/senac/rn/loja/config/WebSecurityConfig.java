package br.senac.rn.loja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.senac.rn.loja.service.UsuarioDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService user;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login", "/css/**", "/js/**", "/fonts/**").permitAll()

		.antMatchers("/produto/**").hasRole("GERENTE")
		.antMatchers("/departamento/**").hasRole("ADMIN")

		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login").successForwardUrl("/marca")
			.defaultSuccessUrl("/marca", true).permitAll();
		super.configure(http);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user).passwordEncoder(new BCryptPasswordEncoder());
	}
	

}

