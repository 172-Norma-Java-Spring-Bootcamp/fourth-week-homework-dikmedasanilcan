package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
    CustomerAddress getCustomerAddressByPhoneNumber(String phoneNumber);
}
