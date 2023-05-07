package com.api.controller;

import com.api.service.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import response.ResponseEnum;
import response.ServerResponseEntity;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class VerificationCodeController {

    @Resource
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification_code")
    public ServerResponseEntity<Map<String, String>> generatorCode(@PathParam("passengerPhone") String passengerPhone,
                                                                   @PathParam("size") Integer size) {
        if (StringUtils.isBlank(passengerPhone) || Objects.isNull(size)) {
            return ServerResponseEntity.fail(ResponseEnum.HTTP_MESSAGE_NOT_READABLE);
        }
        return verificationCodeService.generatorCode(passengerPhone, size);
    }

    @PostMapping("/verification_code_check")
    public ServerResponseEntity<String> checkVerificationCode(@RequestParam("passengerPhone") String passengerPhone
            , @RequestParam("verificationCode") String verificationCode) {
        if (StringUtils.isBlank(passengerPhone) || StringUtils.isBlank(verificationCode)) {
            return ServerResponseEntity.fail(ResponseEnum.HTTP_MESSAGE_NOT_READABLE);
        }
        return verificationCodeService.checkVerificationCode(passengerPhone, verificationCode);
    }
}
