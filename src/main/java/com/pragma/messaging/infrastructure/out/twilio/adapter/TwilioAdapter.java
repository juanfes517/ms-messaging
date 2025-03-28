package com.pragma.messaging.infrastructure.out.twilio.adapter;

import com.pragma.messaging.domain.spi.ITwilioExternalService;
import com.pragma.messaging.infrastructure.helper.constants.TwilioConstants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioAdapter implements ITwilioExternalService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String accountToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Override
    public String sendSms(String phoneNumber, String message) {
        Twilio.init(accountSid, accountToken);

        Message.creator(
                new com.twilio.type.PhoneNumber(phoneNumber),
                new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                message
        ).create();

        return TwilioConstants.TWILIO_SUCCESS_MESSAGE;
    }
}

