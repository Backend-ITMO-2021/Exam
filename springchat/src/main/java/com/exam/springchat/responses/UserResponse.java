package com.exam.springchat.responses;
import com.exam.springchat.entities.MessageEntity;
import com.exam.springchat.utils.InitiateUtils;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    private final String status;
    private final Integer code;
    private final String username;
    private final ArrayList<String> messages;

    public UserResponse(String status, Integer code, String username) {
        this.status = status;
        this.code = code;
        this.username=username;

        List<MessageEntity> all = InitiateUtils.getM();
        this.messages = new ArrayList<>();
        for (MessageEntity entity : all) {
            if (entity.getSender().equals(this.username)) {
                messages.add(entity.getText());
            }
        }
    }



    public ArrayList<String> getMessages() {
        return messages;
    }
}
