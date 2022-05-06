package org.patikadev.orderexample.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class BrandDTO {
    private final String name;
    private final String image;
}
