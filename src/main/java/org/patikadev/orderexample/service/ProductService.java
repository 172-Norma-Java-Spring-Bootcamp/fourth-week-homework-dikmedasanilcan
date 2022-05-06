package org.patikadev.orderexample.service;

import org.patikadev.orderexample.dto.CreateProductRequestDTO;
import org.patikadev.orderexample.dto.GetProductsResponseDTO;
import org.patikadev.orderexample.exception.BaseException;

import java.util.Collection;

public interface ProductService {

    void create(CreateProductRequestDTO productDTO);

    CreateProductRequestDTO getProduct(Long id) throws BaseException;

    Collection<GetProductsResponseDTO> getProducts();

    void delete(Long id) throws BaseException;

}
