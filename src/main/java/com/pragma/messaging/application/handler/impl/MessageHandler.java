package com.pragma.messaging.application.handler.impl;

import com.pragma.messaging.domain.api.IMessageServicePort;
import com.pragma.messaging.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageServicePort {

    private final IMessageServicePort messageServicePort;

    @Override
    public String sendOrderReadyMessage(Message message) {
        return messageServicePort.sendOrderReadyMessage(message);
    }
}
