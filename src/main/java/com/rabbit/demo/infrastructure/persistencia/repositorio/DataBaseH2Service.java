package com.rabbit.demo.infrastructure.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.demo.domain.service.dependency.MessageRepositoryI;
import com.rabbit.demo.infrastructure.persistencia.entities.Message;

@Service
public class DataBaseH2Service implements MessageRepositoryI {
	
	@Autowired
	MessageRepo messageRepo;


	@Override
	public boolean guardarMensaje(com.rabbit.demo.domain.modelo.Message mensaje) {
		Message entidad = new Message();
		entidad.setMensaje(mensaje.getMensaje());
		try {
			messageRepo.save(entidad);
		}catch(Exception e) {
			System.out.println("Hubo un problema con el guardado a la base de datos "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<com.rabbit.demo.domain.modelo.Message> listarMensajes() {
		try{
			List<Message> listEntities = (List<Message>) messageRepo.findAll();
			return listEntities.stream().map(x ->  new com.rabbit.demo.domain.modelo.Message(x.getMensaje())).collect(Collectors.toList());
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}

}
