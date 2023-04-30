package com.api.service;

import com.api.utils.RandomUtils;
import org.springframework.stereotype.Service;

@Service
public class NumberCodeService {

    public String getNumberCode(Integer size) {
        return RandomUtils.generateRandomString(size);
    }
}
