package com.rabbit.demo.infrastructure.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rabbit.demo.infrastructure.persistencia.entities.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {

}
