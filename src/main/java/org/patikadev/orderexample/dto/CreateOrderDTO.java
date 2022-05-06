package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Data
@RequiredArgsConstructor
public final class CreateOrderDTO {
    private final Long customer;
    private final Long basket;
    private final String paymentMethod;
}
