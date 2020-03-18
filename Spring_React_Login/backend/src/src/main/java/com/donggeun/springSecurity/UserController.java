package com.donggeun.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

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

    @PostMapping("/login")
    public Response login(@RequestBody RequestLoginUser user){
        Response response = new Response();
        System.out.print(user.getUsername()+ " : " + user.getPassword());
        try{
            User loginUser = authService.loginUser(user.getUsername(),user.getPassword());
            System.out.print("체크포인트 1");
            if(loginUser!=null){
                System.out.print("체크포인트 2");
                response.setResponse("success");
                response.setMessage("로그인을 성공적으로 수행했습니다.");
                response.setData(loginUser);
            }else{
                System.out.print("체크포인트 3");
                throw new Exception();
            }
        }catch(Exception e){
            response.setResponse("error");
            response.setMessage("로그인을 실패했습니다.");
            response.setData(null);
        }
        return response;
    }
}
