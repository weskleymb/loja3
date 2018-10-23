package br.senac.rn.loja;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {
<<<<<<< HEAD
	
	public static void main(String[] args) {
		System.out.println("Senha: " + new BCryptPasswordEncoder().encode("senac"));
	}

=======

	public static void main(String[] args) {
		System.out.println("=====================================================");
		System.out.println("Senha: " + new BCryptPasswordEncoder().encode("12345"));
		System.out.println("=====================================================");
	}
	
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
