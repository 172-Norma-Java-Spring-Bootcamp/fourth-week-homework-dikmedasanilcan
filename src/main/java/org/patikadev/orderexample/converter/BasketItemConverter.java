package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateBasketItemDTO;
import org.patikadev.orderexample.dto.GetBasketItemDTO;
import org.patikadev.orderexample.model.BasketItem;

public interface BasketItemConverter {
    BasketItem toBasketItem(CreateBasketItemDTO createBasketItemDTO);
    GetBasketItemDTO toGetBasketItemsDTO(BasketItem basketItem);
}
