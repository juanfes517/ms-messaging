package com.pragma.messaging.infrastructure.helper.constants;

public class ApiConstants {

    private ApiConstants() {}

    public static final String MESSAGE_CONTROLLER = "/api/v1/messages";
    public static final String SEND_ORDER_READY_ENDPOINT = "/ready-message";

    public static final String OK_DESCRIPTION = "Request successful";
    public static final String INTERNAL_SERVER_ERROR_DESCRIPTION = "Internal server error";
    public static final String SEND_ORDER_READY_DESCRIPTION = "Notify via Twilio that an order is ready";
}
