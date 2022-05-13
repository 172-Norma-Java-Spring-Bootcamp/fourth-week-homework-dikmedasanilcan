package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Collection<Customer> findCustomersByIsDeleted(boolean isDeleted);
    Customer getCustomerByEmail(String email);
    Customer getCustomerByUsername(String email);
}
