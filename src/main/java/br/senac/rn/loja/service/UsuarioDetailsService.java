package br.senac.rn.loja.service;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.senac.rn.loja.model.Usuario;
import br.senac.rn.loja.repository.UsuarioRepository;

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
}
