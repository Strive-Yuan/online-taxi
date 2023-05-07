package com.api.service;

import com.api.dto.PassengerUser;
import com.api.mapper.PassengerUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import response.ResponseEnum;
import response.ServerResponseEntity;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PassengerUserService {

    private static final Logger logger = LoggerFactory.getLogger(PassengerUserService.class);

    @Resource
    private PassengerUserMapper passengerUserMapper;

    public ServerResponseEntity<String> create(String passengerPhone) {
        //查询用户信息
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(Map.of("passenger_phone", passengerPhone));
        if (!passengerUsers.isEmpty()) {
            return ServerResponseEntity.fail("用户已存在!");
        }
        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName("小刘");
        passengerUser.setPassengerPhone(passengerPhone);
        passengerUser.setPassengerGender(0);
        passengerUser.setGmtCreate(LocalDateTime.now());
        passengerUser.setState(0);
        passengerUserMapper.insert(passengerUser);
        logger.info("新增用户:" + "小刘");
        return ServerResponseEntity.success("用户注册成功!");
    }
}
