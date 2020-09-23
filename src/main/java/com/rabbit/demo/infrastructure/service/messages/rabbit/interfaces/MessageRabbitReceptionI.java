package com.rabbit.demo.infrastructure.service.messages.rabbit.interfaces;

import com.rabbit.demo.application.service.interfaces.messages.MessageReceptionI;

public interface MessageRabbitReceptionI extends MessageReceptionI {
	public String getNameMethod();
}
