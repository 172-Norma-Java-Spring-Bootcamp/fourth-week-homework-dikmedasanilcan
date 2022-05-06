package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.model.Product;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class GetBasketItemDTO {
    private final Product product;
    private final BigDecimal quantity;

}
