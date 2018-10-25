package br.senac.rn.loja.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.rn.loja.model.Usuario;
import br.senac.rn.loja.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
 
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
		Usuario u = usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
}
