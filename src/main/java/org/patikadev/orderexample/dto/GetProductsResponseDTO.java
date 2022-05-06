package org.patikadev.orderexample.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.model.Brand;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class GetProductsResponseDTO {
    private final String name;
    private final BigDecimal price;
    private final String image;
    private final Brand brand;
}
