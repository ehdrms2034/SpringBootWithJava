package com.donggeun.redistest;

import com.donggeun.redistest.Service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedistestApplicationTests {

	@Autowired
	private RedisService redisService;

	@Test
	void contextLoads() {
	}

	@Test
	void setData(){
		redisService.setData("hello");
	}

}
