package com.donggeun.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUpUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User loginUser(String id, String password) {
        User user = userRepository.findByUsername(id);
        if(user==null){
            System.out.print("씨이이이바");
            return null;
        }
        if(user.getPassword().equals(password)){
            return user;
        }else
            return null;
    }
}
