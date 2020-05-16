package com.donggeun.redistest.Service;

import java.time.Duration;

public interface RedisService {
    String getData(String key);

    void setData(String key, String value);


    void setDataExpire(String key, String value, int duration);
}
