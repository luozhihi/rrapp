package com.lzh.rrapp.scheduled;

import com.lzh.rrapp.enumType.ServerTypeEnum;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @auther LuoZhiHui
 * @date 2020/3/2 15:26
 */
@Component
public class InitMessage {
    private static final Logger logger = LoggerFactory.getLogger(InitMessage.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostConstruct
    public void init(){
        queryMsg();
    }

    @Scheduled(fixedRate = 1000*60)
    public void queryMsg(){
        logger.info(">>>>>>>>>>>>>>  start update message  <<<<<<<<<<<<<<<");
        ServerTypeEnum[] serverTypes = ServerTypeEnum.values();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 查询并更新，缓存数据
        for (ServerTypeEnum serverType : serverTypes) {
            String url = serverType.getValue();
            HttpGet httpGet = new HttpGet("url");
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
//                response.getEntity().getContent().read()
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info(">>>>>>>>>>>>>>  end update message  <<<<<<<<<<<<<<<");

    }
}
