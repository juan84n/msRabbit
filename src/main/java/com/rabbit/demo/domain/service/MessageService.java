package com.rabbit.demo.domain.service;

import java.util.List;

import com.rabbit.demo.domain.modelo.Message;
import com.rabbit.demo.domain.service.dependency.MessageRepositoryI;

public class MessageService {

	private MessageRepositoryI messageRepository;
	
	public MessageService(MessageRepositoryI messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public boolean agregarMensaje(Message mensaje) {
		return this.messageRepository.guardarMensaje(mensaje);
	}
	
	public List<Message> listadoMensajes(){
		return this.messageRepository.listarMensajes();
	}
}
