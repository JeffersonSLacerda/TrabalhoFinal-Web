package com.ufc.web.restaurante.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "chef")
public class Chefe extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true, length = 100)
	private String nome;

	@OneToMany(mappedBy = "chefe")
	private List<Prato> prato;
	
	public List<Prato> getPrato() {
		return prato;
	}

	public void setPrato(List<Prato> prato) {
		this.prato = prato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
