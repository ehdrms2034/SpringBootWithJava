package com.example.eurekaclient2;

import com.netflix.discovery.converters.Auto;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(method = RequestMethod.GET, value="/test")
    public ResponseEntity<?> test(){
        HashMap<String,String> data = new HashMap<>();
        data.put("text","나는 클라이언트 2에서 보내졌습니다.");
        return ResponseEntity.status(200).body(data);
    }

    @RequestMapping(method = RequestMethod.GET,value="/eureka1")
    public ResponseEntity<?> test2(){
        Map<String,String> data = testService.getMessageByClient1();
        return ResponseEntity.status(200).body(data);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/send")
    public ResponseEntity<?> test3(){
        testService.sendMessage("서버2에서 카프카로 전송하는 메시지입니다.");
        HashMap<String,String> data = new HashMap<>();
        data.put("text","서버2에서 카프카로 전송하는 메시지입니다.");
        return ResponseEntity.status(200).body(data);
    }

}
