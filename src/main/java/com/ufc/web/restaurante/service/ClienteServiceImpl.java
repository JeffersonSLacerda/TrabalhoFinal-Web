package com.ufc.web.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufc.web.restaurante.dao.ClienteDao;
import com.ufc.web.restaurante.domain.Cliente;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao dao;
	
	@Override
	public void save(Cliente cliente) {
		dao.save(cliente);		
	}

	@Override
	public void update(Cliente cliente) {
		dao.update(cliente);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByName(String nome) {
		
		return dao.findByName(nome);
	}

	@Override
	public List<Cliente> findByEmail(String email) {
		
		return dao.finByEmail(email);
	}

}
