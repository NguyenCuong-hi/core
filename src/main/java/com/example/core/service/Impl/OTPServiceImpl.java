package com.example.core.service.Impl;

import com.example.core.service.OTPService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class OTPServiceImpl implements OTPService {

    @Value("${security.oauth2.expire-min}")
    private int EXPIRE_MIN;

    @Value("${security.oauth2.from-phone}")
    private String fromPhoneNumber;

    @Value("${security.oauth2.message-otp}")
    private String strMessage;



    private final LoadingCache<String, String> cache = CacheBuilder
            .newBuilder()
            .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
            .build(new CacheLoader<>() {
                @Override
                public String load(String s) {
                    return "";
                }
            });


    @Override
    public String generateOTP(String phoneNumber) {
        PhoneNumber to = new PhoneNumber(phoneNumber);
        PhoneNumber from = new PhoneNumber(fromPhoneNumber);
        String strOTP = randomOTP(phoneNumber);
        strMessage += "{strOTP}";
        Message message = Message.creator(to, from, strMessage).create();
        return strOTP;
    }

    private String randomOTP(String toPhoneNumber) {
        String otp = new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
        cache.put(toPhoneNumber, otp);
        return otp;
    }

    @Override
    public String getCacheOTP(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            return "";
        }
    }

    @Override
    public void clearOTP(String key) {
        cache.invalidate(key);
    }
}
