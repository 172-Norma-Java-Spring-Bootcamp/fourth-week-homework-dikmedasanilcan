package org.patikadev.orderexample.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.converter.BasketConverter;
import org.patikadev.orderexample.dto.CreateBasketDTO;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.patikadev.orderexample.model.Basket;
import org.patikadev.orderexample.model.Customer;
import org.patikadev.orderexample.repository.BasketRepository;
import org.patikadev.orderexample.repository.CustomerRepository;
import org.patikadev.orderexample.service.BasketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketConverter basketConverter;
    private final CustomerRepository customerRepository;

    private static final BigDecimal SHIPPING_PRICE = BigDecimal.valueOf(50);
    @Override
    public void create(CreateBasketDTO createBasketDTO) {
        Customer customer = customerRepository.getById(createBasketDTO.getCustomer());
        Basket basket = basketConverter.toBasket(createBasketDTO);
        basket.setCustomer(customer);
        basket.setPrice(BigDecimal.ZERO);
        basket.setTotalPrice(BigDecimal.ZERO);
        basket.setShippingPrice(SHIPPING_PRICE);
        basketRepository.save(basket);
    }

    @Override
    public Basket getBasket(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new BusinessServiceOperationException.BasketNotFoundException("Basket Not Found"));
    }
}
