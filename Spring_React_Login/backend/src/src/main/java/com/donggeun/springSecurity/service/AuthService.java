package com.donggeun.springSecurity.service;

import com.donggeun.springSecurity.config.UserRole;
import com.donggeun.springSecurity.model.Member;
import javassist.NotFoundException;

public interface AuthService {
    void signUpUser(Member member);

    Member loginUser(String id, String password) throws Exception;

    Member findByUsername(String username) throws NotFoundException;

    void verifyEmail(String key) throws NotFoundException;

    void sendVerificationMail(Member member) throws NotFoundException;

    void modifyUserRole(Member member, UserRole userRole);
}
