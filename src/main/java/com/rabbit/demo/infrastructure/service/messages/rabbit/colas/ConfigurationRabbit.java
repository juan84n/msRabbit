package com.rabbit.demo.infrastructure.service.messages.rabbit.colas;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbit.demo.infrastructure.service.messages.rabbit.interfaces.MessageRabbitReceptionI;


@Configuration
public class ConfigurationRabbit {
	public static final String EXCHANGE_NAME = "demoSpringRabbit2";
    public static final String ROUTING_KEY = "routing_key2";
 
    private static final String QUEUE_NAME = "demoRabbit2";
    private static final boolean IS_DURABLE_QUEUE = false;
 
    @Bean
    Queue queue2() {
        return new Queue(QUEUE_NAME, IS_DURABLE_QUEUE);
    }
 
    @Bean
    TopicExchange exchange2() {
        return new TopicExchange(EXCHANGE_NAME);
    }
 
    @Bean
    Binding binding2(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
 
    @Bean
    SimpleMessageListenerContainer container2(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
 
    /*@Bean
    ReceiverRabbit receiver() {
        return new ReceiverRabbit();
    }*/
 
    @Bean
    MessageListenerAdapter listenerAdapter2(MessageRabbitReceptionI receiver) {
        return new MessageListenerAdapter(receiver, receiver.getNameMethod());
    }
}
