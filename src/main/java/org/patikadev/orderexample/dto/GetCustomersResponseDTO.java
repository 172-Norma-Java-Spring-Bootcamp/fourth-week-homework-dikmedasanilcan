package org.patikadev.orderexample.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.model.Gender;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class GetCustomersResponseDTO {
    private final String username;
    private final String email;
    private final Gender gender;
    private final CustomerAddressDTO address;


}
