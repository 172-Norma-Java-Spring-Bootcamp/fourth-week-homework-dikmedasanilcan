package org.patikadev.orderexample.converter;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateBasketItemDTO;
import org.patikadev.orderexample.dto.GetBasketItemDTO;
import org.patikadev.orderexample.model.BasketItem;
import org.patikadev.orderexample.repository.BasketRepository;
import org.patikadev.orderexample.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketItemConverterImpl implements BasketItemConverter {
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;

    @Override
    public BasketItem toBasketItem(CreateBasketItemDTO createBasketItemDTO) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProduct(productRepository.getById(createBasketItemDTO.getProduct()));
        basketItem.setBasket(basketRepository.getById(createBasketItemDTO.getBasket()));
        basketItem.setQuantity(createBasketItemDTO.getQuantity());
        basketItem.setPrice(basketItem.getProduct().getPrice().multiply(basketItem.getQuantity()));
        return basketItem;
    }

    public GetBasketItemDTO toGetBasketItemsDTO(BasketItem basketItem){
        return new GetBasketItemDTO(basketItem.getProduct(),basketItem.getQuantity());
    }

}
