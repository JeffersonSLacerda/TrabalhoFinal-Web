package com.ufc.web.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufc.web.restaurante.dao.ChefeDao;
import com.ufc.web.restaurante.domain.Chefe;

@Service
@Transactional(readOnly = false)
public class ChefeServiceImpl implements ChefeService{
	
	@Autowired
	private ChefeDao dao;
	
	@Override
	public void save(Chefe chefe) {
		dao.save(chefe);
		
	}

	@Override
	public void update(Chefe chefe) {
		dao.update(chefe);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Chefe findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Chefe> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean chefeTemPrato(Long id) {
		if(findById(id).getPrato().isEmpty()) {
			return false;
		}
		return true;
	}

}
