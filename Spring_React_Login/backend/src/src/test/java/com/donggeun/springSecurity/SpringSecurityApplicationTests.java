package com.donggeun.springSecurity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testDB(){
		User user = new User();
		user.setId("user1");
		user.setPassword("a1234");
		user.setName("김동근");
		user.setEmail("ehdrms2034@naver.com");
		user.setAddress("부산광역시 부산진구 땡땡로 땡땡길 101동 1001호");
		userRepository.save(user);
	}
}
