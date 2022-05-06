package org.patikadev.orderexample.converter;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.dto.CreateProductRequestDTO;
import org.patikadev.orderexample.dto.GetProductsResponseDTO;
import org.patikadev.orderexample.model.Product;
import org.patikadev.orderexample.repository.BrandRepository;
import org.patikadev.orderexample.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductConverterImpl implements ProductConverter{
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product toProduct(CreateProductRequestDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBarcode(UUID.randomUUID());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setBrand(brandRepository.getById(productDTO.getBrand()));
        product.setCategory(categoryRepository.getById(productDTO.getCategory()));
        product.setCreatedAt(new Date());
        product.setCreatedBy("MertBatuhan");
        product.setStock(productDTO.getStock());
        return product;
    }

    @Override
    public CreateProductRequestDTO toCreateProductRequestDTO(Product product) {
       return new CreateProductRequestDTO(product.getName(),
               product.getPrice(),
               product.getImage(),
               product.getBrand().getId(),
               product.getCategory().getId(),
               product.getStock());
    }

    @Override
    public GetProductsResponseDTO toGetProductResponseDTO(Product product) {
        return new GetProductsResponseDTO(product.getName(),
                product.getPrice(),product.getImage(),product.getBrand());
    }
}
