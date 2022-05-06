package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class CustomerAddressDTO {
    private final String phoneNumber;
    private final String country;
    private final String city;
    private final String postalCode;
    private final String description;
}
