package org.patikadev.orderexample.validator;

import org.patikadev.orderexample.dto.CreateCustomerRequestDTO;
import org.patikadev.orderexample.exception.BaseException;
import org.patikadev.orderexample.exception.ValidationOperationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.Objects;

@Component
public class CreateCustomerRequestValidator implements Validator<CreateCustomerRequestDTO>{

    @Override
    public void validate(CreateCustomerRequestDTO customerDTO) throws BaseException {
        if (Objects.isNull(customerDTO)) {
            throw new ValidationOperationException.CustomerNotValidException("Customer can not be null or empty");
        }
        if (!(StringUtils.hasLength(customerDTO.getUsername()))) {
            throw new ValidationOperationException.CustomerNotValidException("Customer username can not be null or empty");
        }
        if (!(StringUtils.hasLength(customerDTO.getEmail()))) {
            throw new ValidationOperationException.CustomerNotValidException("Customer email can not be null or empty");
        }
        if(!customerDTO.getUsername().matches("^[A-Za-z][A-Za-z0-9_]{7,29}$")){
            throw new ValidationOperationException.CustomerNotValidException("Customer name is not correct");

        }
        if(!customerDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
        {
            throw new ValidationOperationException.CustomerNotValidException("Customer email is not correct");

        }
        if (!(StringUtils.hasLength(customerDTO.getPassword()))) {
            throw new ValidationOperationException.CustomerNotValidException("Customer password can not be null or empty");
        }
        if(!customerDTO.getPassword().matches("^[A-Za-z][A-Za-z0-9_]{7,29}$")){
            throw new ValidationOperationException.CustomerNotValidException("Customer password is not correct");
        }
        if (Objects.isNull(customerDTO.getIdentity())) {
            throw new ValidationOperationException.CustomerNotValidException("Customer identity can not be null or empty");
        }
        if (Objects.isNull(customerDTO.getGender())) {
            throw new ValidationOperationException.CustomerNotValidException("Customer gender can not be null or empty");
        }


    }
}
