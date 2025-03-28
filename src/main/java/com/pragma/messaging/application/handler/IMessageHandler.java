package com.pragma.messaging.application.handler;

import com.pragma.messaging.domain.model.Message;

public interface IMessageHandler {

    String sendOrderReadyMessage(Message message);
}
