package org.patikadev.orderexample.service;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.converter.OrderConverter;
import org.patikadev.orderexample.dto.CreateOrderDTO;
import org.patikadev.orderexample.model.Order;
import org.patikadev.orderexample.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    @Override
    public void create(CreateOrderDTO createOrderDTO) {
        Order order = orderConverter.toOrder(createOrderDTO);
        orderRepository.save(order);
    }
}
