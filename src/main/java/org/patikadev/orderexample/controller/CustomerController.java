package org.patikadev.orderexample.controller;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateCustomerRequestDTO;
import org.patikadev.orderexample.dto.GetCustomersResponseDTO;
import org.patikadev.orderexample.service.CustomerService;
import org.patikadev.orderexample.validator.CustomerIdValidator;
import org.patikadev.orderexample.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final Validator<CreateCustomerRequestDTO> createCustomerValidator;
    private final CustomerIdValidator customerIdValidator;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCustomerRequestDTO customerDTO) {
        createCustomerValidator.validate(customerDTO);
        customerService.create(customerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCustomerRequestDTO> getCustomer(@PathVariable Long id) {
        customerIdValidator.validate(id);
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetCustomersResponseDTO>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerIdValidator.validate(id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}