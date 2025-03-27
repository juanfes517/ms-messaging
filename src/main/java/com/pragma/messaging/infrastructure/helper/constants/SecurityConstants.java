package com.pragma.messaging.infrastructure.helper;

public class SecurityConstants {

    private SecurityConstants() {}

    private static final String[] PUBLIC_ENDPOINTS = {
            "/v1/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
    };

    public static String[] getPublicEndpoints() {
        return PUBLIC_ENDPOINTS.clone();
    }
}
