package com.rabbit.demo.infrastructure.service.messages.rabbit.colas;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbit.demo.infrastructure.service.messages.rabbit.interfaces.MessageRabbitReceptionI;


@Configuration
public class SendMessageRabbit {
	
	public static final String EXCHANGE_NAME = "demoSpringRabbit";
    public static final String ROUTING_KEY = "routing_key";
 
    private static final String QUEUE_NAME = "demoRabbit";
    private static final boolean IS_DURABLE_QUEUE = false;
    
    @Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, IS_DURABLE_QUEUE);
	}

    @Bean
	public Exchange exchange() {
		 return new TopicExchange(EXCHANGE_NAME);
	}

    @Bean
	public Binding binding(Queue queue, Exchange exchange) {
		return BindingBuilder.bind(queue).to((TopicExchange)exchange).with(ROUTING_KEY);
	}

    @Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
	}

    @Bean
	public MessageListenerAdapter listenerAdapter(MessageRabbitReceptionI receiver) {
		 return new MessageListenerAdapter(receiver, receiver.getNameMethod());
	}

}
