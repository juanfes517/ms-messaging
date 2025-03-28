package com.pragma.messaging.application.dto.request;


import com.pragma.messaging.application.helper.constants.DtoConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MessageRequestDto {

    @NotBlank(message = DtoConstants.CUSTOMER_CELL_PHONE_NUMBER_CANNOT_BE_BLANK)
    private String customerCellPhoneNumber;

    @NotBlank(message = DtoConstants.RESTAURANT_NAME_CANNOT_BE_BLANK)
    private String restaurantName;

    @NotBlank(message = DtoConstants.SECURITY_PIN_CANNOT_BE_BLANK)
    private String securityPin;
}
