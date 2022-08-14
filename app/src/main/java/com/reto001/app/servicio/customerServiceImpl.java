package com.reto001.app.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.reto001.app.converter.customerDtoToEntity;
import com.reto001.app.converter.customerEntityToDto;
import com.reto001.app.dominio.customers;


import com.reto001.app.dto.customerDTO;
import com.reto001.app.dto.indicadoresDTORequest;
import com.reto001.app.dto.indicadoresDTOResponse;
import com.reto001.app.repository.customerRepository;


@RestController
public class customerServiceImpl implements customerService {

	@Autowired
	customerRepository repo;

	@Override
	public customerDTO Create(customerDTO request) throws Exception {
		
		request.setFechaCreacion(new Date());

		customers cus = customerDtoToEntity.INSTANCE.apply(request);

		customers cguardado = repo.save(cus);
		
		return customerEntityToDto.INSTANCE.apply(cguardado);
	}

	@Override
	public List<customerDTO> consultar(customerDTO request) throws Exception {
		
		List<customers> result = new ArrayList<customers>();
		List<customerDTO> response = new ArrayList<customerDTO>();
		
	
		result = (List<customers>) repo.findByDniOrEmail(request.getDni(),request.getEmail());
		
		response = Lists.transform(result, customerEntityToDto.INSTANCE);
		
		
		return response;
	}

	@Override
	public indicadoresDTOResponse getIndicadores(indicadoresDTORequest request) throws Exception {
		
		indicadoresDTOResponse  response = new indicadoresDTOResponse();
		
	 Long cantidadClientes = repo.count();
	 long ind = repo.cantidadNacidos(request.getMes(), request.getAnio());
	 
	 double p = 0.0;
	 
	 BigDecimal bd = new BigDecimal((ind*1.0/cantidadClientes)*1000).setScale(2, RoundingMode.HALF_UP);
	  p = bd.doubleValue();	 
	 Float tasaNat =  Float.parseFloat(p+"");
			
		response.setCantidadNacidos(Long.parseLong(ind+""));
		response.setTasaNatalidad(tasaNat);
		
		
		
		List<Map<String, Object>> lstMayor =   repo.getMesMayorNacimientos(request.getAnio());
		String mapMayor = lstMayor.get(0).values().toString();	
		
		List<Map<String, Object>>  lstMenor =  repo.getMesMenorNacimientos(request.getAnio());		
		String mapMenor = lstMenor.get(0).values().toString();		
		
		response.setMesMenorCantidadNacidos(this.getMes(mapMenor));
		response.setMesMayorCantidadNacidos(this.getMes(mapMayor));
		
		
		return response;
	}
	
	
	private String  getMes( String strMap) {
		
		strMap = strMap.replace("[", "").replace("]", "");		
		String[] newStr = strMap.split(",");
		
		return newStr[1].trim();
	}

}
