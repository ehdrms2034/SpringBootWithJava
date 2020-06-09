package com.donggeun.springSecurity.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String response;
    private String message;
    private Object data;

    public Response(String response, String message, Object data) {
        this.response = response;
        this.message = message;
        this.data = data;
    }

}