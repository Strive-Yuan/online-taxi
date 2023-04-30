package com.api.controller;


import com.api.remote.VerificationCodeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ServerResponseEntity;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class NumberCodeController {

    @Autowired
    VerificationCodeClient verificationCodeClient;

    @GetMapping("/generator_code")
    public ServerResponseEntity<String> generatorCode(@PathParam("size") Integer size) {
        ServerResponseEntity<String> numberCode = verificationCodeClient.getNumberCode(size);
        System.out.println("feign远程调用成功! code:" + numberCode.getData());
        return numberCode;
    }
}
