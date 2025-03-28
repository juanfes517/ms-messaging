package com.pragma.messaging.infrastructure.configuration;

import com.pragma.messaging.domain.api.IMessageServicePort;
import com.pragma.messaging.domain.spi.ITwilioExternalService;
import com.pragma.messaging.domain.usecase.MessageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IMessageServicePort messageService(ITwilioExternalService twilioExternalService) {
        return new MessageUseCase(twilioExternalService);
    }
}
