package com.pragma.messaging.domain.spi;

public interface ITwilioExternalService {

    String sendSms(String phoneNumber, String message);
}
