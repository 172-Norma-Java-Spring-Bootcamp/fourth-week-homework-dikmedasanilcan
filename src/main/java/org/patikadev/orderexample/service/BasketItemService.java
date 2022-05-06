package org.patikadev.orderexample.service;

import org.patikadev.orderexample.dto.CreateBasketItemDTO;
import org.patikadev.orderexample.dto.GetBasketItemDTO;

import java.util.Collection;

public interface BasketItemService {
    void create(CreateBasketItemDTO basketItem);
    Collection<GetBasketItemDTO> getBasketItems(Long id);

}
