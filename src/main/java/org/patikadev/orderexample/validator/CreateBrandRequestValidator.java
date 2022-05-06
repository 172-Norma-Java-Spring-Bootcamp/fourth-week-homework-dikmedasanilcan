package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.dto.BrandDTO;
import org.patikadev.orderexample.exception.BaseValidationException;
import org.patikadev.orderexample.exception.ValidationOperationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
public class CreateBrandRequestValidator implements Validator<BrandDTO>{
    @Override
    public void validate(BrandDTO brandDTO) throws BaseValidationException {
        if(Objects.isNull(brandDTO)){
            throw new ValidationOperationException.BrandNotValidException("Brand can not be null or empty");
        }
        if(!(StringUtils.hasLength(brandDTO.getName()))|| brandDTO.getName().isBlank()){
            throw new ValidationOperationException.BrandNotValidException("Brand name can not be null or empty");
        }
    }
}
