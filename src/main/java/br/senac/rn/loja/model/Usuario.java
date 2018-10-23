package br.senac.rn.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table
@Entity
public class Usuario {
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
=======

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
	private Integer id;
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotEmpty
<<<<<<< HEAD
	private String Password;
	@NotEmpty
	private String nome;
	@NotEmpty
	private boolean admin;
=======
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private Boolean admin;
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
	
	public Integer getId() {
		return id;
	}
<<<<<<< HEAD
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = new BCryptPasswordEncoder().encode(password);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", Password=" + Password + ", nome=" + nome + "]";
	}

=======
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
