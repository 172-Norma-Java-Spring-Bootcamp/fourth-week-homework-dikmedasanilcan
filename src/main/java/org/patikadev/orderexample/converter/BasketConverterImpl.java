package org.patikadev.orderexample.converter;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateBasketDTO;
import org.patikadev.orderexample.model.Basket;
import org.patikadev.orderexample.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketConverterImpl implements BasketConverter {
    private final CustomerRepository customerRepository;


    @Override
    public Basket toBasket(CreateBasketDTO createBasketDTO) {
        Basket basket = new Basket();
        basket.setCustomer(customerRepository.getById(createBasketDTO.getCustomer()));
        return basket;
    }
}
