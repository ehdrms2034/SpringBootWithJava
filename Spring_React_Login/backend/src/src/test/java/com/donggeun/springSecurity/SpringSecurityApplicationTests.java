package com.donggeun.springSecurity;

import com.donggeun.springSecurity.model.Member;
import com.donggeun.springSecurity.repository.MemberRepository;
import com.donggeun.springSecurity.service.AuthService;
import com.donggeun.springSecurity.service.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private MemberRepository memberRepository;


	@Autowired
	private JwtUtil jwtUtil;

	@Test
	void contextLoads() {
	}

	@Test
	void testDB(){
		Member member = new Member();
		member.setUsername("user1");
		member.setPassword("a1234");
		member.setName("김동근");
		member.setEmail("ehdrms2034@naver.com");
		member.setAddress("부산광역시 부산진구 땡땡로 땡땡길 101동 1001호");
		memberRepository.save(member);
	}

	@Test
	void test(){

		String username = jwtUtil.getUsername("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImVoZHJtczIwMzQiLCJpYXQiOjE1ODQ2MTkzMTMsImV4cCI6MTU4NDYyMTExM30.llLcxtXVoI3xBROLrrru1IYXSAADywNwtb9IBMhXzfQ");
		System.out.println(username);
	}
}
