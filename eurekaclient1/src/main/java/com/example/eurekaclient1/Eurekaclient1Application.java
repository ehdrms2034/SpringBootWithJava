package com.example.eurekaclient1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Sink.class)
@EnableKafka
@Slf4j
public class Eurekaclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient1Application.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(Map<String,String> message){
        log.info("Received an event for server {} , content : {}", message.get("server"),message.get("content"));
    }

}
