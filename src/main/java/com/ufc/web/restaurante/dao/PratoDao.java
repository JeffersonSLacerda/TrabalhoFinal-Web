package com.ufc.web.restaurante.dao;

import java.util.List;

import com.ufc.web.restaurante.domain.Prato;

public interface PratoDao {

	void save(Prato prato);
	
	void update(Prato prato);
	
	void delete(Long id);
	
	Prato findById(Long id);
	
	List<Prato> findAll();

	List<Prato> findByName(String nome);
}
