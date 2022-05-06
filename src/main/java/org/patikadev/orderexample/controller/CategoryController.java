package org.patikadev.orderexample.controller;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.dto.GetCategoryResponseDTO;
import org.patikadev.orderexample.service.CategoryService;
import org.patikadev.orderexample.validator.CategoryIdValidator;
import org.patikadev.orderexample.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final Validator<CreateCategoryRequestDTO> createCategoryRequestDTOValidator;
    private final CategoryIdValidator categoryIdValidator;
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        createCategoryRequestDTOValidator.validate(createCategoryRequestDTO);
        categoryService.create(createCategoryRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCategoryRequestDTO> getCategory(@PathVariable Long id){
        categoryIdValidator.validate(id);
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<Collection<GetCategoryResponseDTO>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryIdValidator.validate(id);
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
