package com.pragma.messaging.domain.api;

import com.pragma.messaging.domain.model.Message;

public interface IMessageServicePort {

    String sendOrderReadyMessage(Message message);
}
