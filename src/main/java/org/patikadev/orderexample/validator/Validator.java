package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.exception.BaseValidationException;
import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {
    void validate(T input) throws BaseValidationException;
}
