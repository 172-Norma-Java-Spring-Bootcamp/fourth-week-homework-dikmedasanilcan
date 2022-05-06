package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
