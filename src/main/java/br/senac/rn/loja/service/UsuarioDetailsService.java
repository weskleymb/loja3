package br.senac.rn.loja.service;

import java.util.List;

<<<<<<< HEAD
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3

import br.senac.rn.loja.model.Usuario;
import br.senac.rn.loja.repository.UsuarioRepository;

<<<<<<< HEAD
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repostiroy;

   @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Usuario user = repostiroy.findByUsername(username);
	if (user == null) {
		throw new UsernameNotFoundException("Usuário não encontrado");
	}
	
	List<GrantedAuthority> permissoes = AuthorityUtils.createAuthorityList("ROLE_USER");
	
	return new User(user.getUsername(), user.getPassword());
}
=======
@Component
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		List<GrantedAuthority> permissoes = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(user.getUsername(), user.getPassword(), permissoes);
	}

>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
