package com.donggeun.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUpUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void loginUser(String id, String Password) {

    }
}
