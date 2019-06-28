package com.ufc.web.restaurante.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufc.web.restaurante.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {

	@Override
	public List<Cliente> findByName(String nome) {
		
		return createQuery("select c from Cliente c where c.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Cliente> finByEmail(String email) {
		
		return createQuery("select c from Cliente c where c.email like concat('%',?1,'%')", email);
	}

}
