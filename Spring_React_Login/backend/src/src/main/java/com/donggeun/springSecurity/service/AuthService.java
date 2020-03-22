package com.donggeun.springSecurity.service;

import com.donggeun.springSecurity.model.Member;

public interface AuthService {
    void signUpUser(Member member);

    Member loginUser(String id, String password);
}
