package com.example.core.service;

public interface OTPService {

    String generateOTP(String phoneNumber);

    String getCacheOTP(String key);

    void clearOTP(String key);
}
