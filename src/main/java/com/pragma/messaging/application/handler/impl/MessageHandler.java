package com.pragma.messaging.application.handler.impl;

import com.pragma.messaging.application.dto.request.MessageRequestDto;
import com.pragma.messaging.application.handler.IMessageHandler;
import com.pragma.messaging.domain.api.IMessageServicePort;
import com.pragma.messaging.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    @Override
    public String sendOrderReadyMessage(MessageRequestDto message) {
        Message mappedMessage = Message.builder()
                .customerCellPhoneNumber(message.getCustomerCellPhoneNumber())
                .restaurantName(message.getRestaurantName())
                .securityPin(message.getSecurityPin())
                .build();
        
        return messageServicePort.sendOrderReadyMessage(mappedMessage);
    }
}
