package com.pragma.messaging.application.handler;

import com.pragma.messaging.application.dto.request.MessageRequestDto;

public interface IMessageHandler {

    String sendOrderReadyMessage(MessageRequestDto message);
}
