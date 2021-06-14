package com.exam.springchat.services;

import com.exam.springchat.entities.MessageEntity;
import com.exam.springchat.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public void save(MessageEntity messageEntity){
        messageRepository.save(messageEntity);
    }

    public List<MessageEntity> getAll(){
        return messageRepository.findAll();
    }
}
