package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CustomerAddressDTO;
import org.patikadev.orderexample.dto.CreateCustomerRequestDTO;
import org.patikadev.orderexample.dto.GetCustomersResponseDTO;
import org.patikadev.orderexample.model.Customer;
import org.patikadev.orderexample.model.CustomerAddress;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerConverterImpl implements CustomerConverter{

    @Override
    public Customer toCustomer(CreateCustomerRequestDTO customerDTO) {

        Customer customer = new Customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setEmail(customerDTO.getEmail());
        customer.setIdentity(customerDTO.getIdentity());
        customer.setGender(customerDTO.getGender());
        customer.setPassword(customerDTO.getPassword());
        customer.setCreatedAt(new Date());
        customer.setCreatedBy("MertBatuhan");

        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setPhoneNumber(customerDTO.getCustomerAddress().getPhoneNumber());
        customerAddress.setCountry(customerDTO.getCustomerAddress().getCountry());
        customerAddress.setCity(customerDTO.getCustomerAddress().getCity());
        customerAddress.setPostalCode(customerDTO.getCustomerAddress().getPostalCode());
        customerAddress.setDescription(customerDTO.getCustomerAddress().getDescription());

        customerAddress.setCustomer(customer);
        customer.setCustomerAddress(customerAddress);

        return customer;
    }

    @Override
    public CreateCustomerRequestDTO toCreateCustomerRequestDTO(Customer customer) {
        return new CreateCustomerRequestDTO(customer.getUsername(),
                customer.getEmail(),
                customer.getIdentity(),
                customer.getGender(),
                customer.getPassword(),
                convertCustomerAddressDto(customer.getCustomerAddress()));

    }

    @Override
    public GetCustomersResponseDTO toGetCustomersResponseDto(Customer customer) {
        return new GetCustomersResponseDTO(customer.getUsername(),
                customer.getEmail(),
                customer.getGender(),
                convertCustomerAddressDto(customer.getCustomerAddress()));
    }

    private CustomerAddressDTO convertCustomerAddressDto(CustomerAddress customerAddress) {
        return new CustomerAddressDTO(customerAddress.getPhoneNumber(),
                customerAddress.getCountry(),
                customerAddress.getCity(),
                customerAddress.getPostalCode(),
                customerAddress.getDescription());
    }
}
