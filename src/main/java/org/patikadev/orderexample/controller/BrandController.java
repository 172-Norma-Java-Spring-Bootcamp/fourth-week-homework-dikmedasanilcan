package org.patikadev.orderexample.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.BrandDTO;

import org.patikadev.orderexample.service.BrandService;
import org.patikadev.orderexample.validator.BrandIdValidator;
import org.patikadev.orderexample.validator.CreateBrandRequestValidator;
import org.patikadev.orderexample.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/brands")
@RequiredArgsConstructor
public class BrandController {
    private  final Validator<BrandDTO> brandDTOValidator;
    private final BrandIdValidator brandIdValidator;
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
        brandDTOValidator.validate(brandDTO);
        brandService.create(brandDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrand(@PathVariable Long id){
        brandIdValidator.validate(id);
        return ResponseEntity.ok(brandService.getBrand(id));
    }

    @GetMapping
    public ResponseEntity<Collection<BrandDTO>> getBrands(){
        return ResponseEntity.ok(brandService.getBrands());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ){
        brandIdValidator.validate(id);
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }
}
