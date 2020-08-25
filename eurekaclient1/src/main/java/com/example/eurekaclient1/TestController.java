package com.example.eurekaclient1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value="/test")
    public ResponseEntity<?> test(){
        HashMap<String,String> data = new HashMap<>();
        data.put("text","나는 클라이언트 1에서 보내졌습니다.");
        return ResponseEntity.status(200).body(data);
    }
}