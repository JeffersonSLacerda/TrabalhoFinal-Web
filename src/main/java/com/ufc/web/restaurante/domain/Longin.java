package com.ufc.web.restaurante.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table
public class Longin extends AbstractEntity<Long> {
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String login;
	
	@Column(nullable = false, length = 16)
	private String password;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
