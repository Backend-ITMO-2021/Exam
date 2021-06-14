package com.exam.springchat.responses;

public class BaseResponse {

    private final String status;
    private final Integer code;
    private final String username;

    public BaseResponse(String status, Integer code, String username) {
        this.status = status;
        this.code = code;
        this.username=username;
    }

    public String getStatus() {
        return status;
    }
    public String getUsername() {
        return username;
    }
    public Integer getCode() {
        return code;
    }
}
