package br.senac.rn.loja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.senac.rn.loja.model.Permissao;
import br.senac.rn.loja.model.Usuario;
import br.senac.rn.loja.repository.UsuarioRepository;

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
		List<String> permissoes = new ArrayList<>();
		for (Permissao permissao: user.getPermissoes()) {
			permissoes.add(permissao.getNome());
		}
		List<GrantedAuthority> autorizacoes = AuthorityUtils.createAuthorityList(permissoes.toArray(new String[0]));
		return new User(user.getUsername(), user.getPassword(), autorizacoes);
	}

}