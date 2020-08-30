package com.example.eurekaclient2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("eurekaclient1")
public interface EurekaClient1 {

    @RequestMapping(method = RequestMethod.GET, value = "/test",consumes = "application/json")
    Map<String,String> getClient1Info();

}
