package com.example.core.configuration;

import com.twilio.Twilio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    @Value("${twilio.account_sid}")
    private String TWILIO_ACC_SID;

    @Value("${twilio.auth}")
    private String TWILIO_AUTH_TOKEN;

    @Bean
    public  void initTwilio(){
        Twilio.init(TWILIO_ACC_SID, TWILIO_AUTH_TOKEN);
    }

}
