package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class CreateBasketItemDTO {
    private final Long basket;
    private final Long product;
    private final BigDecimal quantity;

}
