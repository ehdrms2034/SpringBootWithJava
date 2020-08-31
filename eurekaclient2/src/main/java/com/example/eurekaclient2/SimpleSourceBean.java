package com.example.eurekaclient2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger= LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishEu2Change(String action, String content){
        logger.debug("Sending kafka message {} for Content: {}",action,content);

        HashMap<String,String> map = new HashMap<>();
        map.put("server","eureka1");
        map.put("content",content);

        source.output().send(MessageBuilder.withPayload(map).build());
    }

}
