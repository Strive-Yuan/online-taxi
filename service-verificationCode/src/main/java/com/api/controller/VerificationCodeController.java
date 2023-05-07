package com.api.controller;

import com.api.service.VerificationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import response.ServerResponseEntity;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api")
public class VerificationCodeController {
    @Resource
    VerificationCodeService verificationCodeService;

    @GetMapping("/number_code")
    public ServerResponseEntity<Map<String,String>> getNumberCode(@RequestParam("size") Integer size) {
        if (size == null) {
            return ServerResponseEntity.fail("size值为空！");
        }
        return ServerResponseEntity.success(Map.of("numberCode", verificationCodeService.getNumberCode(size)));
    }
}
