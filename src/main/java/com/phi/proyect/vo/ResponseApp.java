package com.phi.proyect.vo;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ResponseApp implements Serializable {

	private static final long serialVersionUID = -3102681092482169138L;
	private HttpStatus status;
	private String mensaje;

	public ResponseApp(HttpStatus status, String mensaje) {
		super();
		this.status = status;
		this.mensaje = mensaje;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
