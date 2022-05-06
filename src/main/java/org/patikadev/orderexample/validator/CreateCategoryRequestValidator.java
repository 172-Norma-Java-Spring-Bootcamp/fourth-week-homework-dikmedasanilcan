package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.exception.BaseValidationException;
import org.patikadev.orderexample.exception.ValidationOperationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
public class CreateCategoryRequestValidator implements Validator<CreateCategoryRequestDTO> {
    @Override
    public void validate(CreateCategoryRequestDTO categoryDTO) throws BaseValidationException {
        if(Objects.isNull(categoryDTO)){
            throw new ValidationOperationException.CategoryNotValidException("Category can not be null or empty");
        }
        if(!StringUtils.hasLength(categoryDTO.getName()) || categoryDTO.getName().isBlank()){
            throw new ValidationOperationException.CategoryNotValidException("Category name can not be null or empty");
        }

    }
}
