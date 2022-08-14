package com.reto001.app.dto;

public class indicadoresDTOResponse {
	

	public String getMesMayorCantidadNacidos() {
		return MesMayorCantidadNacidos;
	}
	public void setMesMayorCantidadNacidos(String mesMayorCantidadNacidos) {
		MesMayorCantidadNacidos = mesMayorCantidadNacidos;
	}

	public String getMesMenorCantidadNacidos() {
		return MesMenorCantidadNacidos;
	}
	public void setMesMenorCantidadNacidos(String mesMenorCantidadNacidos) {
		MesMenorCantidadNacidos = mesMenorCantidadNacidos;
	}

	public float getTasaNatalidad() {
		return TasaNatalidad;
	}
	public void setTasaNatalidad(float tasaNatalidad) {
		TasaNatalidad = tasaNatalidad;
	}
	private Long CantidadNacidos;
	public Long getCantidadNacidos() {
		return CantidadNacidos;
	}
	public void setCantidadNacidos(Long cantidadNacidos) {
		CantidadNacidos = cantidadNacidos;
	}
	private String  MesMayorCantidadNacidos;
	private String  MesMenorCantidadNacidos;
	private float TasaNatalidad;

}
