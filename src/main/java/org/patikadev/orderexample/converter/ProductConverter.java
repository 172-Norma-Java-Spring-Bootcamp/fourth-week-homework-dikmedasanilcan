package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.CreateProductRequestDTO;
import org.patikadev.orderexample.dto.GetProductsResponseDTO;
import org.patikadev.orderexample.model.Product;

public interface ProductConverter {

    Product toProduct(CreateProductRequestDTO productDTO);
    CreateProductRequestDTO toCreateProductRequestDTO(Product product);
    GetProductsResponseDTO toGetProductResponseDTO(Product product);
}
