package com.donggeun.springSecurity.controller;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.model.RequestLoginUser;
import com.donggeun.springSecurity.model.Response;
import com.donggeun.springSecurity.service.AuthService;
import com.donggeun.springSecurity.service.CookieUtil;
import com.donggeun.springSecurity.service.JwtUtil;
import com.donggeun.springSecurity.service.RedisUtil;
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
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthService authService;
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/signup")
    public Response signUpUser(@RequestBody Member member) {
        try {
            authService.signUpUser(member);
            return new Response("success","회원가입을 성공적으로 완료했습니다.",null);
        } catch (Exception e) {
            return new Response("error","회원가입을 하는 도중 오류가 발생했습니다.",null);
        }
    }

    @PostMapping("/login")
    public Response login(@RequestBody RequestLoginUser user,
                          HttpServletRequest req,
                          HttpServletResponse res) {
        try {
            final Member member = authService.loginUser(user.getUsername(), user.getPassword());
            final String token = jwtUtil.generateToken(member);
            final String refreshJwt = jwtUtil.generateRefreshToken(member);
            Cookie accessToken = cookieUtil.createCookie("Authorization", token);
            Cookie refreshToken = cookieUtil.createCookie("refreshToken",refreshJwt);
            redisUtil.setDataExpire(refreshJwt,member.getUsername(),JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
            res.addCookie(accessToken);
            res.addCookie(refreshToken);
            return new Response("success", "로그인에 성공했습니다.", token);
        } catch (Exception e) {
            return new Response("error", "로그인에 실패했습니다.", e.getMessage());
        }
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
