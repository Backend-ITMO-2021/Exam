package com.exam.springchat.responses;
import com.exam.springchat.entities.MessageEntity;
import com.exam.springchat.utils.InitiateUtils;

import javax.naming.ldap.HasControls;
import java.util.*;

public class AllMResponse {

    private final String status;
    private final Integer code;
    private final ArrayList<Map> messages;

    public AllMResponse(String status, Integer code) {
        this.status = status;
        this.code = code;

        List<MessageEntity> all = InitiateUtils.getM();
        this.messages = new ArrayList<>();
        for (MessageEntity entity : all) {
                Map map = new LinkedHashMap();
                map.put("id",entity.getId());
                map.put("username",entity.getSender());
                map.put("message",entity.getText());
                map.put("date",entity.getDate());
                map.put("replyTo", entity.getReply());


                messages.add(map);
        }
    }



    public ArrayList<Map> getMessages() {
        return messages;
    }
}
