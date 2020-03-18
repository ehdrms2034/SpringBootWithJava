package com.donggeun.springSecurity;

public interface AuthService {
    void signUpUser(User user);

    User loginUser(String id,String password);
}
