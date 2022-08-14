package com.reto001.app.converter;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.reto001.app.dominio.customers;
import com.reto001.app.dto.customerDTO;

public enum customerDtoToEntity implements Function<customerDTO, customers> {
	
	INSTANCE;
	
	@Override
	public customers apply(customerDTO t) {
		
		customers entidad = new customers();
		
		if(t != null) {
			
			BeanUtils.copyProperties(t, entidad);
			
		}

		return entidad;
	}
	

}
