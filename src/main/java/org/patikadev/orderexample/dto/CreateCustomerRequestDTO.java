package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.model.Gender;


import javax.validation.constraints.Pattern;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class CreateCustomerRequestDTO {
    private final String username;
    private final String email;
    private final Long identity;
    private final Gender gender;
    private final String password;
    private final CustomerAddressDTO customerAddress;


}
