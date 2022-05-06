package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.exception.BaseValidationException;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdValidator implements Validator<Long>{
    @Override
    public void validate(Long input) throws BaseValidationException {
        if(input<0){
            throw new BusinessServiceOperationException.CategoryNotFoundException("Category not found");
        }

    }
}
