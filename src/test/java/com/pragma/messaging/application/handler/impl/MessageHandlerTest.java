package com.pragma.messaging.application.handler.impl;

import com.pragma.messaging.application.dto.request.MessageRequestDto;
import com.pragma.messaging.domain.api.IMessageServicePort;
import com.pragma.messaging.domain.model.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageHandlerTest {

    @InjectMocks
    private MessageHandler messageHandler;

    @Mock
    private IMessageServicePort messageServicePort;

    @Test
    void sendOrderReadyMessage_WhenIsSuccessful() {
        MessageRequestDto message = MessageRequestDto.builder()
                .customerCellPhoneNumber("+2123123124")
                .restaurantName("Restaurant Name")
                .securityPin("123454")
                .build();

        String exitMessage = "Message sent successfully";

        when(messageServicePort.sendOrderReadyMessage(any(Message.class)))
                .thenReturn(exitMessage);

        String result = messageHandler.sendOrderReadyMessage(message);

        assertNotNull(result);
        assertEquals(exitMessage, result);
    }
}