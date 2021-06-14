package com.exam.springchat.controller;
import com.exam.springchat.responses.UserResponse;
import org.springframework.web.bind.annotation.*;
import com.exam.springchat.responses.BaseResponse;
import com.exam.springchat.utils.InitiateUtils;

@RestController
@RequestMapping("/messages/{username}")
public class ApiController {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public UserResponse showStatus(@PathVariable("username") String username) {
        return new UserResponse(SUCCESS_STATUS, 1, username);
    }



}
