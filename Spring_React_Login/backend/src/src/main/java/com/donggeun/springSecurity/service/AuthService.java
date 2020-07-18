package com.donggeun.springSecurity.service;

import com.donggeun.springSecurity.config.UserRole;
import com.donggeun.springSecurity.model.Member;

public interface AuthService {
    void signUpUser(Member member);

    Member loginUser(String id, String password) throws Exception;

    void modifyUserRole(Member member, UserRole userRole);
}
