package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.dto.GetCategoryResponseDTO;
import org.patikadev.orderexample.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverterImpl implements CategoryConverter {

    @Override
    public Category toCategory(CreateCategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setParent(categoryDTO.getParent());
        category.setName(categoryDTO.getName());
        return category;
    }

    @Override
    public CreateCategoryRequestDTO toCreateCategoryRequestDTO(Category category) {
        return new CreateCategoryRequestDTO(category.getParent(), category.getName());
    }

    @Override
    public GetCategoryResponseDTO toGetCategoryResponseDto(Category category) {
        return new GetCategoryResponseDTO(category.getName());
    }
}
