package com.ufc.web.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufc.web.restaurante.dao.PratoDao;
import com.ufc.web.restaurante.domain.Prato;

@Service @Transactional(readOnly = false)
public class PratoServiceImpl implements PratoService {
	
	@Autowired
	private PratoDao dao;
	
	@Override
	public void save(Prato prato) {
		dao.save(prato);
		
	}

	@Override
	public void update(Prato prato) {
		dao.update(prato);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Prato findById(Long id) {
	
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Prato> findAll() {

		return dao.findAll();
	}

	@Override @Transactional(readOnly = true)
	public List<Prato> findByName(String nome) {
		
		return dao.findByName(nome);
	}

}
