package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.GetCustomersResponseDTO;
import org.patikadev.orderexample.model.Customer;
import org.patikadev.orderexample.dto.CreateCustomerRequestDTO;

public interface CustomerConverter {

    Customer toCustomer(CreateCustomerRequestDTO customerDTO);

    CreateCustomerRequestDTO toCreateCustomerRequestDTO(Customer customer);

    GetCustomersResponseDTO toGetCustomersResponseDto(Customer customer);
    
}
