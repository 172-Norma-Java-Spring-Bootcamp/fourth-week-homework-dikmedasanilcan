package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateBasketDTO;
import org.patikadev.orderexample.model.Basket;

public interface BasketConverter {
    Basket toBasket(CreateBasketDTO createBasketDTO);
}
