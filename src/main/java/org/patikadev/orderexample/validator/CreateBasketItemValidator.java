package org.patikadev.orderexample.validator;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateBasketItemDTO;
import org.patikadev.orderexample.exception.BaseValidationException;
import org.patikadev.orderexample.exception.ValidationOperationException;
import org.patikadev.orderexample.service.BasketService;
import org.patikadev.orderexample.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateBasketItemValidator implements Validator<CreateBasketItemDTO> {
    private final ProductService productService;
    private final BasketService basketService;
    @Override
    public void validate(CreateBasketItemDTO createBasketItemDTO) throws BaseValidationException {
        if(Objects.isNull(createBasketItemDTO)){
            throw new ValidationOperationException.BasketItemNotValid("This item is not in any basket");
        }
        if(Objects.isNull(productService.getProduct(createBasketItemDTO.getProduct()))){
            throw new ValidationOperationException.BasketItemNotValid("Product not found");
        }
        if(Objects.isNull(basketService.getBasket(createBasketItemDTO.getBasket()))){
            throw new ValidationOperationException.BasketItemNotValid("Basket not found");
        }
        if(createBasketItemDTO.getQuantity().intValueExact()<0){
            throw new ValidationOperationException.BasketItemNotValid("Item Quantity must be greater than zero");
        }
    }
}
