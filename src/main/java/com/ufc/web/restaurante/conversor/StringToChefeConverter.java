package com.ufc.web.restaurante.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ufc.web.restaurante.domain.Chefe;
import com.ufc.web.restaurante.service.ChefeService;

@Component
public class StringToChefeConverter implements Converter<String, Chefe>{

	@Autowired
	private ChefeService service;
	
	@Override
	public Chefe convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.findById(id);
	}
	
}
