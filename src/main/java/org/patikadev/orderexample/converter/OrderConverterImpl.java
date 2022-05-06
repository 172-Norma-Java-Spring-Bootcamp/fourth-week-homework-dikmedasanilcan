package org.patikadev.orderexample.converter;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateOrderDTO;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.patikadev.orderexample.model.Order;
import org.patikadev.orderexample.model.Status;
import org.patikadev.orderexample.repository.BasketRepository;
import org.patikadev.orderexample.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class OrderConverterImpl implements OrderConverter {
    private final CustomerRepository customerRepository;
    private final BasketRepository basketRepository;
    @Override
    public Order toOrder(CreateOrderDTO orderDTO) {
        if(customerRepository.findById(orderDTO.getCustomer()).isEmpty()){
            throw new BusinessServiceOperationException.CustomerNotFoundException("Customer not found");
        }
        if(basketRepository.findById(orderDTO.getBasket()).isEmpty()){
            throw new BusinessServiceOperationException.BasketNotFoundException("Basket not found");
        }
        if(!basketRepository.getById(orderDTO.getBasket()).getCustomer().getId().equals(orderDTO.getCustomer())){
            throw new BusinessServiceOperationException.BasketNotFoundException("This basket is not belong to this customer");
        }
        Order order = new Order();
        order.setCustomer(customerRepository.getById(orderDTO.getCustomer()));
        order.setBasket(basketRepository.getById(orderDTO.getBasket()));
        order.setOrderedDate(new Date());
        order.setStatus(Status.NEW);
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        return order;
    }
}
