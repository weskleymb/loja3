package br.senac.rn.loja.config;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.senac.rn.loja.model.Usuario;
<<<<<<< HEAD
=======
import br.senac.rn.loja.repository.UsuarioRepository;
import br.senac.rn.loja.service.UsuarioDetailsService;
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
<<<<<<< HEAD
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/css/**", "/js/**", "/fonts/**").permitAll()
=======

	@Autowired
	private UsuarioDetailsService user;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login", "/css/**", "/js/**", "/fonts/**").permitAll()
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login").successForwardUrl("/marca")
<<<<<<< HEAD
			.defaultSuccessUrl("/marca", true).permitAll();	
=======
			.defaultSuccessUrl("/marca", true).permitAll();
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
		super.configure(http);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
<<<<<<< HEAD
		Usuario user = new Usuario();
		user.setUsername("admin");
		user.setPassword("senac");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.withUser(user.getUsername()).password(user.getPassword()).roles("USER");
	}

=======
		auth.userDetailsService(user).passwordEncoder(new BCryptPasswordEncoder());
	}
	
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
