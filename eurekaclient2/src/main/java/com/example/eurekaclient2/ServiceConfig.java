package com.example.eurekaclient2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ServiceConfig {

    @Value("${redis.server}")
    private String redisServer;

    @Value("${redis.port}")
    private String redisPort;

}
