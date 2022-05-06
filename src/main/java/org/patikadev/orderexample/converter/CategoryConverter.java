package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.dto.GetCategoryResponseDTO;
import org.patikadev.orderexample.model.Category;

public interface CategoryConverter {
    Category toCategory(CreateCategoryRequestDTO categoryDTO);
    CreateCategoryRequestDTO toCreateCategoryRequestDTO(Category category);
    GetCategoryResponseDTO toGetCategoryResponseDto(Category category);
}
