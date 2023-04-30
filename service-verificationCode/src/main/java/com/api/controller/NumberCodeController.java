package com.api.controller;


import com.api.response.ResponseEnum;
import com.api.response.ServerResponseEntity;
import com.api.service.NumberCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api")
public class NumberCodeController {

    private static final Logger logger = LoggerFactory.getLogger(NumberCodeController.class);
    @Resource
    NumberCodeService numberCodeService;

    @GetMapping("number_code")
    public ServerResponseEntity<String> getNumberCode(@PathParam("size") Integer size) {
        if (size == null) {
            return ServerResponseEntity.fail(ResponseEnum.PARAM_ERROR);
        }
        return ServerResponseEntity.success(numberCodeService.getNumberCode(size));
    }
}
