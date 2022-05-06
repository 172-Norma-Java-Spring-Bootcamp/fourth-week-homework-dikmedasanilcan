package org.patikadev.orderexample.controller;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateBasketDTO;
import org.patikadev.orderexample.dto.CreateBasketItemDTO;
import org.patikadev.orderexample.dto.GetBasketItemDTO;
import org.patikadev.orderexample.service.BasketItemService;
import org.patikadev.orderexample.service.BasketService;
import org.patikadev.orderexample.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/basket")
public class BasketController {
    private final BasketService basketService;
    private final BasketItemService basketItemService;
    private final Validator<CreateBasketItemDTO> basketItemValidator;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBasketDTO createBasketDTO){
        basketService.create(createBasketDTO);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/addItem")
    public ResponseEntity<?> create(@RequestBody CreateBasketItemDTO createBasketItemDTO){
        basketItemValidator.validate(createBasketItemDTO);
        basketItemService.create(createBasketItemDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Collection<GetBasketItemDTO>> getBasket(@PathVariable Long id){
        return ResponseEntity.ok(basketItemService.getBasketItems(id));
    }
}
