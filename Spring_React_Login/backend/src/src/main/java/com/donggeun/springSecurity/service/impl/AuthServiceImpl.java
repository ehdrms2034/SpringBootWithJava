package com.donggeun.springSecurity.service.impl;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.model.Salt;
import com.donggeun.springSecurity.repository.MemberRepository;
import com.donggeun.springSecurity.repository.SaltRepository;
import com.donggeun.springSecurity.service.AuthService;
import com.donggeun.springSecurity.service.RedisUtil;
import com.donggeun.springSecurity.service.SaltUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SaltRepository saltRepository;

    @Autowired
    private SaltUtil saltUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional
    public void signUpUser(Member member) {
        String password = member.getPassword();
        String salt = saltUtil.genSalt();
        log.info(salt);
        member.setSalt(new Salt(salt));
        member.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(member);
    }

    @Override
    public Member loginUser(String id, String password) throws Exception{
        Member member = memberRepository.findByUsername(id);
        if(member==null) throw new Exception ("멤버가 조회되지 않음");
        String salt = member.getSalt().getSalt();
        password = saltUtil.encodePassword(salt,password);
        if(!member.getPassword().equals(password))
            throw new Exception ("비밀번호가 틀립니다.");
        return member;
    }


}