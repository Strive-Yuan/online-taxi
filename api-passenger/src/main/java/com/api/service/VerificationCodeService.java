package com.api.service;

import com.api.remote.ServicePassengerClient;
import com.api.remote.VerificationCodeClient;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import response.ResponseEnum;
import response.ServerResponseEntity;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    private static final Logger logger = LoggerFactory.getLogger(VerificationCodeService.class);

    private static final String VERIFICATION_CODE_PREFIX = "passenger-verification-code-";

    @Resource
    private RedissonClient redissonClient;
    @Resource
    private VerificationCodeClient verificationCodeClient;
    @Resource
    private ServicePassengerClient servicePassengerClient;

    public ServerResponseEntity<Map<String, String>> generatorCode(String passengerPhone, Integer size) {
        ServerResponseEntity<Map<String, String>> numberCode = verificationCodeClient.getNumberCode(size);
        logger.info("feign远程调用成功! code:{}", numberCode.getData().get("numberCode"));
        var bucket = redissonClient.getBucket(VERIFICATION_CODE_PREFIX + passengerPhone);
        bucket.set(numberCode.getData().get("numberCode"), 2, TimeUnit.MINUTES);
        //发短信(待实现)
        return numberCode;
    }

    public ServerResponseEntity<String> checkVerificationCode(String passengerPhone, String verificationCode) {
        RBucket<Object> bucket = redissonClient.getBucket(VERIFICATION_CODE_PREFIX + passengerPhone);
        logger.info("获取redis中的验证码：{}", bucket.get());
        if (!verificationCode.trim().equals(bucket.get())) {
            return ServerResponseEntity.fail(ResponseEnum.VERIFICATION_CODE_ERROR);
        }

        servicePassengerClient.createUser(passengerPhone);
        //生成token

        return ServerResponseEntity.success();
    }
}
