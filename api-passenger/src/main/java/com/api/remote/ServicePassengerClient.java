package com.api.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import response.ServerResponseEntity;

import java.util.Map;

@FeignClient("service-verificationCode")
public interface ServicePassengerClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/user")
    ServerResponseEntity<Map<String, String>> createUser(@RequestParam("passengerPhone") String passengerPhone);
}
