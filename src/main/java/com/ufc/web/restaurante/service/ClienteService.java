package com.ufc.web.restaurante.service;

import java.util.List;

import com.ufc.web.restaurante.domain.Cliente;

public interface ClienteService {

	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
	
	Cliente findById(Long id);
	
	List<Cliente> findAll();

	List<Cliente> findByName(String nome);
	
	List<Cliente> findByEmail(String email);
}
