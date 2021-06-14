package com.exam.springchat.controller;

import com.exam.springchat.responses.AllMResponse;
import com.exam.springchat.responses.StatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all-messages")
public class AllMController {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public AllMResponse showStatus() {
        return new AllMResponse(SUCCESS_STATUS, 1);
    }



}
