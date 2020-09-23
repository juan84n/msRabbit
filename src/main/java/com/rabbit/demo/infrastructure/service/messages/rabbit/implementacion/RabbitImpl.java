package com.rabbit.demo.infrastructure.service.messages.rabbit.implementacion;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.demo.application.interfaces.messages.MessageI;
import com.rabbit.demo.infrastructure.service.messages.rabbit.colas.SendMessageRabbit;


@Service
public class RabbitImpl implements MessageI {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
 
	@Override
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(SendMessageRabbit.EXCHANGE_NAME, SendMessageRabbit.ROUTING_KEY, message);
		
	}
}
