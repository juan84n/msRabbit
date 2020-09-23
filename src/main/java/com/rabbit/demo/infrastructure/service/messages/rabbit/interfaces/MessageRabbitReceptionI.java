package com.rabbit.demo.infrastructure.service.messages.rabbit.interfaces;

import com.rabbit.demo.application.interfaces.messages.MessageReceptionI;

public interface MessageRabbitReceptionI extends MessageReceptionI {
	public String getNameMethod();
}
