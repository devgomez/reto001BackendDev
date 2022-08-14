package com.reto001.app.converter;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.reto001.app.dominio.customers;
import com.reto001.app.dto.customerDTO;

public enum customerEntityToDto implements Function<customers, customerDTO> {

	INSTANCE;

	@Override
	public customerDTO apply(customers from) {

		customerDTO dto = new customerDTO();

		if (from != null) {

			BeanUtils.copyProperties(from, dto);

		}

		return dto;
	}

}
