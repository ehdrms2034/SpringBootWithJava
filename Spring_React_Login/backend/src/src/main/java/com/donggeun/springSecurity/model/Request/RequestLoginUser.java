package com.donggeun.springSecurity.model.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginUser {
    private String username;
    private String password;

    public RequestLoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
