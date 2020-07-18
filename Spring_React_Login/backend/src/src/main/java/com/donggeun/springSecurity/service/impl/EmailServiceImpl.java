package com.donggeun.springSecurity.service.impl;

import com.donggeun.springSecurity.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendFirstVerificationMail(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("[로그인서버] 회원가입 사용자 인증 메일입니다.");
        message.setText("일단은 테스트만 요리조리 할 예정");
        emailSender.send(message);
    }
}
