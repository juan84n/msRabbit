package com.rabbit.demo.infrastructure.service.messages.rabbit.implementacion;

import org.springframework.stereotype.Component;

import com.rabbit.demo.infrastructure.service.messages.rabbit.interfaces.MessageRabbitReceptionI;

@Component
public class ReceiverRabbit implements MessageRabbitReceptionI {
    
    @Override
    public void receiveMessage(String message) {
        System.out.println("[Receiver] ha recibido el mensaje \"" + message + '"');
    }

	@Override
	public String getNameMethod() {
		return "receiveMessage";
	}
}
