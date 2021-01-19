package br.com.alura.microservice.loja.handler.utils;

import java.time.LocalDateTime;

public class Erro {
	
	private LocalDateTime timestamp;
	private String message;
	private String path;
	
	public Erro(String message, String path) {
		this.message = message;
		this.path = path;
		this.timestamp = LocalDateTime.now();
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
