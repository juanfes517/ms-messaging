package com.pragma.messaging.domain.usecase;

import com.pragma.messaging.domain.api.IMessageServicePort;
import com.pragma.messaging.domain.model.Message;
import com.pragma.messaging.domain.spi.ITwilioExternalService;
import com.pragma.messaging.helper.constants.MessageConstants;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {

    private final ITwilioExternalService twilioExternalService;

    @Override
    public String sendOrderReadyMessage(Message message) {
        String readyMessage = MessageConstants.READY_MESSAGE + "\n" +
                MessageConstants.RESTAURANT_NAME + message.getRestaurantName() + "\n" +
                MessageConstants.SECURITY_PIN_MESSAGE + message.getSecurityPin();
        return twilioExternalService.sendSms(message.getCustomerCellPhoneNumber(), readyMessage);
    }
}
