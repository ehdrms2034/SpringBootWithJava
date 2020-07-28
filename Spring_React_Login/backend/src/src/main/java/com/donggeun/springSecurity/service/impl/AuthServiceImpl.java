package com.donggeun.springSecurity.service.impl;

import com.donggeun.springSecurity.config.UserRole;
import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.model.Request.RequestSocialData;
import com.donggeun.springSecurity.model.Salt;
import com.donggeun.springSecurity.model.SocialData;
import com.donggeun.springSecurity.repository.MemberRepository;
import com.donggeun.springSecurity.repository.SocialDataRepository;
import com.donggeun.springSecurity.service.AuthService;
import com.donggeun.springSecurity.service.EmailService;
import com.donggeun.springSecurity.service.RedisUtil;
import com.donggeun.springSecurity.service.SaltUtil;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SaltUtil saltUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SocialDataRepository socialDataRepository;

    @Override
    @Transactional
    public void signUpUser(Member member) {
        String password = member.getPassword();
        String salt = saltUtil.genSalt();
        member.setSalt(new Salt(salt));
        member.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void signUpSocialUser(RequestSocialData member){
        Member newMember = new Member();
        newMember.setUsername(member.getId());
        newMember.setPassword("");
        newMember.setEmail(member.getEmail());
        newMember.setName(member.getName());
        newMember.setAddress("");
        newMember.setSocial(new SocialData(member.getId(),member.getEmail(),member.getType()));
        memberRepository.save(newMember);
    }

    @Override
    public Member loginSocialUser(String id, String type) throws NotFoundException{
        SocialData socialData = socialDataRepository.findByIdAndType(id,type);
        if(socialData==null) throw new NotFoundException("멤버가 조회되지 않음");
        return socialData.getMember();
    }

    @Override
    public Member loginUser(String id, String password) throws Exception{
        Member member = memberRepository.findByUsername(id);
        if(member==null) throw new Exception ("멤버가 조회되지 않음");
        String salt = member.getSalt().getSalt();
        password = saltUtil.encodePassword(salt,password);
        if(!member.getPassword().equals(password))
            throw new Exception ("비밀번호가 틀립니다.");
        if(member.getSocial()!=null)
            throw new Exception ("소셜 계정으로 로그인 해주세요.");
        return member;
    }

    @Override
    public Member findByUsername(String username) throws NotFoundException {
        Member member = memberRepository.findByUsername(username);
        if(member == null) throw new NotFoundException("멤버가 조회되지 않음");
        return member;
    }

    @Override
    public void verifyEmail(String key) throws NotFoundException {
        String memberId = redisUtil.getData(key);
        Member member = memberRepository.findByUsername(memberId);
        if(member==null) throw new NotFoundException("멤버가 조회되지않음");
        modifyUserRole(member,UserRole.ROLE_USER);
        redisUtil.deleteData(key);
    }

    @Override
    public void sendVerificationMail(Member member) throws NotFoundException {
        String VERIFICATION_LINK = "http://localhost:8080/user/verify/";
        if(member==null) throw new NotFoundException("멤버가 조회되지 않음");
        UUID uuid = UUID.randomUUID();
        redisUtil.setDataExpire(uuid.toString(),member.getUsername(), 60 * 30L);
        emailService.sendMail(member.getEmail(),"[김동근 스프링] 회원가입 인증메일입니다.",VERIFICATION_LINK+uuid.toString());
    }

    @Override
    public void modifyUserRole(Member member, UserRole userRole){
            member.setRole(userRole);
            memberRepository.save(member);
    }

    @Override
    public boolean isPasswordUuidValidate(String key){
        String memberId = redisUtil.getData(key);
        return !memberId.equals("");
    }

    @Override
    public void changePassword(Member member,String password) throws NotFoundException{
        if(member == null) throw new NotFoundException("changePassword(),멤버가 조회되지 않음");
        String salt = saltUtil.genSalt();
        member.setSalt(new Salt(salt));
        member.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(member);
    }


    @Override
    public void requestChangePassword(Member member) throws NotFoundException{
        String CHANGE_PASSWORD_LINK = "http://localhost:8080/user/password/";
        if(member == null) throw new NotFoundException("멤버가 조회되지 않음.");
        String key = REDIS_CHANGE_PASSWORD_PREFIX+UUID.randomUUID();
        redisUtil.setDataExpire(key,member.getUsername(),60 * 30L);
        emailService.sendMail(member.getEmail(),"[김동근 스프링] 사용자 비밀번호 안내 메일",CHANGE_PASSWORD_LINK+key);
    }


}