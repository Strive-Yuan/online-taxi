package com.api.controller;

import com.api.service.PassengerUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import response.ServerResponseEntity;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class PassengerUserController {

    @Resource
    private PassengerUserService passengerUserService;

    @PostMapping("/user")
    public ServerResponseEntity<String> create(@RequestParam("passengerPhone") String passengerPhone) {
        System.out.println(passengerPhone);
        return passengerUserService.create(passengerPhone);
    }
}
