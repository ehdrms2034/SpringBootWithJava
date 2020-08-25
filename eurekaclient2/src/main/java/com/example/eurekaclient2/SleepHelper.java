package com.example.eurekaclient2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class SleepHelper {
    public void RandomlyRunLong(){
        Random random = new Random();
        int randomNum = random.nextInt((3-1)+1)+1;
        if(randomNum==3) {
            log.info("슬립상태");
            sleep();
        }
    }

    private void sleep(){
        try{
            Thread.sleep(11000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
