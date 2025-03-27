package com.pragma.messaging.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Message {

    private String customerCellPhoneNumber;
    private String restaurantName;
    private String securityPin;
}
