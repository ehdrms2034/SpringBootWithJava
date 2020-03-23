package com.donggeun.springSecurity.controller;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.model.RequestLoginUser;
import com.donggeun.springSecurity.model.Response;
import com.donggeun.springSecurity.service.AuthService;
import com.donggeun.springSecurity.service.CookieUtil;
import com.donggeun.springSecurity.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public Response signUpUser(@RequestBody Member member){
        Response response = new Response();

        try{
            authService.signUpUser(member);
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
    public Response login(@RequestBody RequestLoginUser user,
                          HttpServletRequest req,
                          HttpServletResponse res

    ){
        Response response = new Response();
        final Member member = authService.loginUser(user.getUsername(),user.getPassword());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        final String token = jwtUtil.generateToken(member);

        if(req.getCookies()!=null){
            System.out.print(req.getCookies().length);
        }

        Cookie accessToken = cookieUtil.createCookie("Authorization",token);
        res.addCookie(accessToken);

        response.setData(token);
        response.setResponse("success");
        response.setMessage("로그인에 성공하였습니다.");
        return response;
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World!";
    }
}
