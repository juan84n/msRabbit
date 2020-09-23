package com.rabbit.demo.infrastructure.shared;

import com.rabbit.demo.infrastructure.persistencia.entities.Message;

public class UtilsApp {
	
	public static com.rabbit.demo.domain.modelo.Message convertirMessageEntityToDomain(com.rabbit.demo.domain.modelo.Message mensaje, Message entity) {
		mensaje.setMensaje(entity.getMensaje());
		return mensaje;
	}
}
