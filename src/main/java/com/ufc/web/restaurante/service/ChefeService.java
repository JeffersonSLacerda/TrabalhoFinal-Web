package com.ufc.web.restaurante.service;

import java.util.List;

import com.ufc.web.restaurante.domain.Chefe;

public interface ChefeService {

	void save(Chefe chefe);
	
	void update(Chefe chefe);
	
	void delete(Long id);
	
	Chefe findById(Long id);
	
	List<Chefe> findAll();

	boolean chefeTemPrato(Long id);
}
