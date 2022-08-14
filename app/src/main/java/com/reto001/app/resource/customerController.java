package com.reto001.app.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reto001.app.dto.customerDTO;
import com.reto001.app.dto.indicadoresDTORequest;
import com.reto001.app.dto.indicadoresDTOResponse;

@RequestMapping("/customer")
public interface customerController {
	
	@PostMapping("/crear")
	public ResponseEntity<customerDTO> crear(@RequestBody customerDTO request) throws Exception;
	
	
	@PostMapping("/consultar")
	public ResponseEntity<List<customerDTO>> consultar( @RequestBody customerDTO request) throws Exception;
	
	@PostMapping("/consultar-indicadores")
	public ResponseEntity<indicadoresDTOResponse> consultarIndicadores( @RequestBody indicadoresDTORequest request) throws Exception;
	

}
