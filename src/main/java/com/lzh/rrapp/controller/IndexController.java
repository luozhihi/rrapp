package com.lzh.rrapp.controller;

import com.alibaba.fastjson.JSON;
import com.lzh.rrapp.entity.AppFile;
import com.lzh.rrapp.entity.BaseResponse;
import com.lzh.rrapp.enumType.ServerTypeEnum;
import com.lzh.rrapp.scheduled.InitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther LuoZhiHui
 * @date 2020/3/2 11:56
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private InitMessage initMessage;
    @GetMapping("")
    public BaseResponse<?> indexMessage(){
        ServerTypeEnum[] servers = ServerTypeEnum.values();
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        List<AppFile> data = new ArrayList<>();
        for (ServerTypeEnum server : servers) {
            String key = server.getName();
            String cacheStr = opsForValue.get(key);
            if(cacheStr != null){
                AppFile file = JSON.parseObject(cacheStr, AppFile.class);
                data.add(file);
            }
        }
        return new BaseResponse<>().buildeResult(data);
    }

    @GetMapping("/update")
    public BaseResponse<?> update(){
        initMessage.init();
        return new BaseResponse<>().buildeResult(true);
    }
}
