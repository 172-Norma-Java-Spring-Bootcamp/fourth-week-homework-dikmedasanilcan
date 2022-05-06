package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateOrderDTO;
import org.patikadev.orderexample.model.Order;

public interface OrderConverter {
    Order toOrder(CreateOrderDTO orderDTO);
}
