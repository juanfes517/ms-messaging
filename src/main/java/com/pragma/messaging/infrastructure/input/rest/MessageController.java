package com.pragma.messaging.infrastructure.input.rest;

import com.pragma.messaging.application.dto.request.MessageRequestDto;
import com.pragma.messaging.application.handler.IMessageHandler;
import com.pragma.messaging.infrastructure.helper.constants.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageHandler messageHandler;

    @Operation(summary = ApiConstants.SEND_ORDER_READY_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ApiConstants.OK_DESCRIPTION, content = @Content),
            @ApiResponse(responseCode = "500", description = ApiConstants.INTERNAL_SERVER_ERROR_DESCRIPTION, content = @Content)
    })
    @PostMapping("/ready-message")
    public ResponseEntity<String> sendOrderReadyMessage(@RequestBody MessageRequestDto message) {
        return ResponseEntity.ok(messageHandler.sendOrderReadyMessage(message));
    }
}
