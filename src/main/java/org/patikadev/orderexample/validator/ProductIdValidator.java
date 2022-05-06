package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.exception.BaseValidationException;
import org.patikadev.orderexample.exception.ValidationOperationException;
import org.springframework.stereotype.Component;

@Component
public class ProductIdValidator implements Validator<Long> {

    @Override
    public void validate(Long input) throws BaseValidationException {
        if(input<0){
            throw new ValidationOperationException.ProductIDNotValidException("Product ID should be greater than zero.");

        }
    }
}
