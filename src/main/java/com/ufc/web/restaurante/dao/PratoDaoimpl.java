package com.ufc.web.restaurante.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufc.web.restaurante.domain.Prato;

@Repository
public class PratoDaoimpl extends AbstractDao<Prato, Long> implements PratoDao{

	@Override
	public List<Prato> findByName(String nome) {
		
		return createQuery("select p from Prato p where p.nome like concat('%',?1,'%')", nome);
	}
	
}
