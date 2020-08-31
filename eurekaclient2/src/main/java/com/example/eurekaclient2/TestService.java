package com.example.eurekaclient2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private EurekaClient1 eurekaClient1;

    @Autowired
    private SleepHelper sleepHelper;

    @Autowired
    private SimpleSourceBean simpleSourceBean;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "13000"
            )},
            fallbackMethod = "buildFallbackMessageByClient1",
            threadPoolKey = "client1CommunicationThreadPool1",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")}
    )
    public Map<String, String> getMessageByClient1() {
        sleepHelper.RandomlyRunLong();
        return eurekaClient1.getClient1Info();
    }


    private Map<String, String> buildFallbackMessageByClient1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("text", "이것은 서버1과의 연결이 여의치 않아 보여주는 폴백 프로세싱 메시지 입니다.");
        return map;
    }

    public void sendMessage(String content){
        simpleSourceBean.publishEu2Change("SEND",content);
    }
}
