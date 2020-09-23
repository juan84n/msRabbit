package com.rabbit.demo.domain.modelo;


public class Message {

	private long id;
	private String mensaje;
	
	public Message(String message) {
		
		if(mensaje.length() > 4) {
			this.mensaje = message;	
		}else {
			System.out.println("No se puede tener un mensaje con menos de 4 caracteres");
		}
	}
	
	public Message() {}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
