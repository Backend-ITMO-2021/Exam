package com.exam.springchat.responses;
import com.exam.springchat.entities.MessageEntity;
import com.exam.springchat.utils.InitiateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

public class StatResponse {

    private final String status;
    private final Integer code;
    private final List<Map.Entry<String, Integer>> top;

    public StatResponse(String status, Integer code) {
        this.status = status;
        this.code = code;

        TreeMap<String, Integer> map = new TreeMap<>();
        List<MessageEntity> all = InitiateUtils.getM();
        for (MessageEntity entity : all) {
            Integer n = map.get(entity.getSender());
            if (n == null){
                n=1;
            }
            else
            {
                ++n;
            }
            map.put(entity.getSender(),n);

        }


        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());

        Integer n = Integer.min(list.size(),10);
        List<Map.Entry<String, Integer>> list1 = list.subList(0,n);
        this.top=list1;
    }


    public List<Map.Entry<String, Integer>> getTop() {
        return top;
    }
}
