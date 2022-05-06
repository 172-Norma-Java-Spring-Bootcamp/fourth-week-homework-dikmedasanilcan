package org.patikadev.orderexample.service;

import org.patikadev.orderexample.dto.CreateBasketDTO;
import org.patikadev.orderexample.model.Basket;

public interface BasketService {
    void create(CreateBasketDTO createBasketDTO);
    Basket getBasket(Long id);
}
