package org.patikadev.orderexample.controller;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateProductRequestDTO;
import org.patikadev.orderexample.dto.GetProductsResponseDTO;
import org.patikadev.orderexample.service.ProductService;
import org.patikadev.orderexample.validator.CreateProductRequestValidator;
import org.patikadev.orderexample.validator.ProductIdValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {
    private final CreateProductRequestValidator createProductValidator;
    private final ProductIdValidator productIdValidator;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequestDTO productDTO){
        createProductValidator.validate(productDTO);
        productService.create(productDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateProductRequestDTO> getProduct(@PathVariable Long id){
        productIdValidator.validate(id);
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetProductsResponseDTO>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productIdValidator.validate(id);
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
