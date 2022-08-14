package com.reto001.app.servicio;

import java.util.List;


import com.reto001.app.dto.customerDTO;
import com.reto001.app.dto.indicadoresDTORequest;
import com.reto001.app.dto.indicadoresDTOResponse;

public interface customerService {
	
	public customerDTO Create (customerDTO request) throws Exception;
	
	public List<customerDTO> consultar (customerDTO request) throws Exception;

	
	public indicadoresDTOResponse getIndicadores( indicadoresDTORequest request) throws Exception;

}
