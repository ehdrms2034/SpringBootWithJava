package com.donggeun.springSecurity;

public interface AuthService {
    void signUpUser(User user);

    void loginUser(String id,String Password);
}
