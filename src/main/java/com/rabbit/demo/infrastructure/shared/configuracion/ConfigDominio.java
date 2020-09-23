package com.rabbit.demo.infrastructure.shared.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbit.demo.domain.service.MessageService;
import com.rabbit.demo.domain.service.dependency.MessageRepositoryI;
import com.rabbit.demo.infrastructure.persistencia.repositorio.DataBaseH2Service;

@Configuration
public class ConfigDominio {
	
    @Bean
    public MessageRepositoryI getMessageRepository() {
    	return new DataBaseH2Service();
    }
    
    @Bean
    public MessageService getMessageService() {
    	return new MessageService(this.getMessageRepository()); 
    }

}
