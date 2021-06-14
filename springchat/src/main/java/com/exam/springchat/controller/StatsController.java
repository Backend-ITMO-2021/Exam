package com.exam.springchat.controller;
import com.exam.springchat.responses.StatResponse;
import com.exam.springchat.responses.UserResponse;
import org.springframework.web.bind.annotation.*;
import com.exam.springchat.responses.BaseResponse;
import com.exam.springchat.utils.InitiateUtils;

@RestController
@RequestMapping("/stats/top")
public class StatsController {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public StatResponse showStatus() {
        return new StatResponse(SUCCESS_STATUS, 1);
    }



}
