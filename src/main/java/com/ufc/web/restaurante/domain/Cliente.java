package com.ufc.web.restaurante.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table
public class Cliente extends AbstractEntity<Long> {

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 150)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_endereco")
	private Endereco endereco;
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
