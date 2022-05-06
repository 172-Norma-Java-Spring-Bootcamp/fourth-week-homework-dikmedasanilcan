package org.patikadev.orderexample.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.model.Category;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public final class CreateCategoryRequestDTO {
    private final Category parent;
    private final String name;



}
