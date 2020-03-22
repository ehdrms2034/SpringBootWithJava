package com.donggeun.springSecurity.service.impl;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.repository.MemberRepository;
import com.donggeun.springSecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void signUpUser(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member loginUser(String id, String password) {
        Member member = memberRepository.findByUsername(id);
        if(member ==null){
            System.out.print("씨이이이바");
            return null;
        }
        if(member.getPassword().equals(password)){
            return member;
        }else
            return null;
    }
}
