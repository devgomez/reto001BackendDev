package com.reto001.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.reto001.app.dto.customerDTO;
import com.reto001.app.dto.indicadoresDTORequest;
import com.reto001.app.dto.indicadoresDTOResponse;
import com.reto001.app.servicio.customerService;

@RestController
public class customerControllerImpl  implements customerController {
	
	@Autowired
	customerService service;
	
	@Override
	public ResponseEntity<customerDTO> crear(customerDTO request) throws Exception {
		
		
		var created = service.Create(request);

		return new  ResponseEntity<customerDTO> (created, HttpStatus.CREATED) ;
		
		
	}

	@Override
	public ResponseEntity<List<customerDTO>> consultar(customerDTO request) throws Exception {
		
		return new  ResponseEntity<List<customerDTO>> (service.consultar(request), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<indicadoresDTOResponse> consultarIndicadores(indicadoresDTORequest request) throws Exception {
		return new  ResponseEntity<indicadoresDTOResponse> (service.getIndicadores(request), HttpStatus.OK);
	}
	
	

}
