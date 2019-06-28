package com.ufc.web.restaurante.service;

import java.util.List;

import com.ufc.web.restaurante.domain.Prato;

public interface PratoService {

	void save(Prato prato);
	
	void update(Prato prato);
	
	void delete(Long id);
	
	Prato findById(Long id);
	
	List<Prato> findAll();

	List<Prato> findByName(String nome);
}
