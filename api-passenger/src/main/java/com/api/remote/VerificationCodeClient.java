package com.api.remote;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import response.ServerResponseEntity;

@FeignClient("service-verificationCode")
public interface VerificationCodeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/number_code")
    ServerResponseEntity<String> getNumberCode(@RequestParam("size") Integer size);
}
