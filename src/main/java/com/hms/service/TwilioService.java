package com.hms.service;

import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class TwilioService {
   // private final String TWILIO_PHONE_NUMBER = "your_twilio_phone_number";

    public String sendSms(String to,String from, String body) {
        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                body
        ).create();
        return message.getSid();
    }
}

