package com.api.service;

import org.springframework.stereotype.Service;
import utils.RandomUtils;

@Service
public class VerificationCodeService {

    public String getNumberCode(Integer size) {
        return RandomUtils.generateRandomString(size);
    }
}
