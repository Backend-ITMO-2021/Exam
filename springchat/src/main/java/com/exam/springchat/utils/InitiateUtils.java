package com.exam.springchat.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import com.exam.springchat.entities.MessageEntity;
import com.exam.springchat.services.MessageService;

import java.util.List;

@Service
public class InitiateUtils implements CommandLineRunner {


    public static MessageService messageService;
    public InitiateUtils (MessageService messageService){
        this.messageService = messageService;
    }


    public static void saveM(MessageEntity messageEntity){
        messageService.save(messageEntity);
    }

    public static List<MessageEntity> getM(){
        List<MessageEntity> all = messageService.getAll();


        return all;
    }
    @Override

    public void run(String... args) throws Exception {


    }


}