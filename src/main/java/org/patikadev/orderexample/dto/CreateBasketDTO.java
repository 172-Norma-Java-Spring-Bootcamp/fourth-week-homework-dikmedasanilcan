package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Data
@RequiredArgsConstructor
public final class CreateBasketDTO {
    private final Long customer;
    private final BigDecimal discountRate;
}
