package com.pragma.messaging.domain.usecase;

import com.pragma.messaging.domain.model.Message;
import com.pragma.messaging.domain.spi.ITwilioExternalService;
import com.pragma.messaging.helper.constants.MessageConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageUseCaseTest {

    @InjectMocks
    private MessageUseCase messageUseCase;

    @Mock
    private ITwilioExternalService twilioExternalService;

    @Test
    void sendOrderReadyMessage() {
        Message message = Message.builder()
                .customerCellPhoneNumber("+1223234234234")
                .restaurantName("Restaurant Name")
                .securityPin("123456")
                .build();

        String readyMessage = MessageConstants.READY_MESSAGE + "\n" +
                MessageConstants.RESTAURANT_NAME + message.getRestaurantName() + "\n" +
                MessageConstants.SECURITY_PIN_MESSAGE + message.getSecurityPin();

        String exitMessage = "Message sent successfully";

        when(twilioExternalService.sendSms(message.getCustomerCellPhoneNumber(), readyMessage))
                .thenReturn(exitMessage);

        String result = messageUseCase.sendOrderReadyMessage(message);

        assertNotNull(result);
        assertEquals(exitMessage, result);
    }
}