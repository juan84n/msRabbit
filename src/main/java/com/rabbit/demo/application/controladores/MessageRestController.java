package com.rabbit.demo.application.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.demo.application.interfaces.messages.MessageI;
import com.rabbit.demo.domain.modelo.Message;
import com.rabbit.demo.domain.service.MessageService;

@RestController
public class MessageRestController {
	
	@Autowired
    MessageI mensajeEnvio;
	
	@Autowired
	MessageService messageServi;
			
	@GetMapping("/message/get/{message}")
	public String sendMessageRabbit(@PathVariable("message") String mensaje) {
		mensajeEnvio.sendMessage(mensaje);
						
		Message mensajeDomain = new Message();
		
		mensajeDomain.setMensaje(mensaje);
		
		messageServi.agregarMensaje(mensajeDomain);
		
		return "El mensaje '"+mensaje+"' ha sido enviado y guardado";
	}
		
   /* @RequestMapping("/")
    public String index() {
    	StringBuilder listado = new StringBuilder();
    	for(Message mensaje : messageServi.listadoMensajes()) {
    		listado.append("- "+mensaje.getMensaje().toUpperCase()+"<br/>");
    	}
        return (listado.length() > 0) ? listado.toString() : "La lista esta vacía";
    	
    }*/
    
    @RequestMapping("/")
    public List<Message> index() {
        return messageServi.listadoMensajes();
    	
    }
    
}
