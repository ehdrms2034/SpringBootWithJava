package com.donggeun.springSecurity;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.model.RequestLoginUser;
import com.donggeun.springSecurity.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void signUp(){
        Member member = new Member();
        member.setUsername("user222");
        member.setPassword("a1234");
        member.setName("김동근");
        member.setEmail("ehdrms2034@naver.com");
        member.setAddress("부산광역시 부산진구 땡땡로 땡땡길 101동 1001호");
        authService.signUpUser(member);
    }

    @Test
    public void login(){
        RequestLoginUser loginUser = new RequestLoginUser("user222","a1234");
        try{
            authService.loginUser(loginUser.getUsername(),loginUser.getPassword());
            log.info("로그인 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
