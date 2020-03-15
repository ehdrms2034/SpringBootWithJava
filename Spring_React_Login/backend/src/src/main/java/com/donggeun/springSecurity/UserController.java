package com.donggeun.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public Response signUpUser(@RequestBody User user){
        Response response = new Response();

        try{
            authService.signUpUser(user);
            response.setResponse("success");
            response.setMessage("회원가입을 성공적으로 완료했습니다.");
        }
        catch(Exception e){
            response.setResponse("failed");
            response.setMessage("회원가입을 하는 도중 오류가 발생했습니다.");
            response.setData(e.toString());
        }

        return response;
    }
}
