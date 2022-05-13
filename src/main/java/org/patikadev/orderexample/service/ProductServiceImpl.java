package org.patikadev.orderexample.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.converter.ProductConverter;
import org.patikadev.orderexample.dto.CreateProductRequestDTO;
import org.patikadev.orderexample.dto.GetProductsResponseDTO;
import org.patikadev.orderexample.exception.BaseException;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.patikadev.orderexample.model.Product;
import org.patikadev.orderexample.repository.BrandRepository;
import org.patikadev.orderexample.repository.CategoryRepository;
import org.patikadev.orderexample.repository.ProductRepository;
import org.patikadev.orderexample.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    @Override
    public void create(CreateProductRequestDTO productDTO) {
        if(categoryRepository.findById(productDTO.getCategory()).isEmpty()){
            throw new BusinessServiceOperationException.CategoryNotFoundException("Category Not Found");
        }
        if(brandRepository.findById(productDTO.getBrand()).isEmpty()){
            throw new BusinessServiceOperationException.BrandNotFoundException("Brand Not Found");
        }
        if(productRepository.getProductByName(productDTO.getName())!=null){
            throw new BusinessServiceOperationException.ProductAlreadyHaveException("Product is already have in our system");
        }
        Product product = productConverter.toProduct(productDTO);
        product.setCategory(categoryRepository.getById(productDTO.getCategory()));
        product.setBrand(brandRepository.getById(productDTO.getBrand()));
        product.setBarcode(UUID.randomUUID());
        productRepository.save(product);
    }

    @Override
    public CreateProductRequestDTO getProduct(Long id) throws BaseException {
       Product product = productRepository.findById(id).orElseThrow(()
               -> new BusinessServiceOperationException.ProductNotFoundException("Product not found"));
       return productConverter.toCreateProductRequestDTO(product);
    }

    @Override
    public Collection<GetProductsResponseDTO> getProducts() {
        return productRepository.findProductByIsDeleted(false)
                .stream()
                .map(productConverter::toGetProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws BaseException {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new BusinessServiceOperationException.ProductNotFoundException("Product not found"));
        if(product.isDeleted()){
            throw new BusinessServiceOperationException.ProductAlreadyDeletedException("Product already deleted");
        }
        product.setDeleted(true);
        productRepository.save(product);
    }
}
