package com.rabbit.demo.domain.service.dependency;

import java.util.List;

import com.rabbit.demo.domain.modelo.Message;

public interface MessageRepositoryI {
	public boolean guardarMensaje(Message mensaje);
	public List<Message> listarMensajes();
}
