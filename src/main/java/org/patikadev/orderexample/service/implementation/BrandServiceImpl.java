package org.patikadev.orderexample.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.converter.BrandConverter;
import org.patikadev.orderexample.dto.BrandDTO;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.patikadev.orderexample.model.Brand;
import org.patikadev.orderexample.repository.BrandRepository;
import org.patikadev.orderexample.repository.ProductRepository;
import org.patikadev.orderexample.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandConverter brandConverter;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    @Override
    public void create(BrandDTO brandDTO) {
        Brand brand = brandConverter.toBrand(brandDTO);
        if(brandRepository.getBrandByName(brandDTO.getName())!=null){
            throw new BusinessServiceOperationException.BrandAlreadyHave("Brand Already have in brands");
        }
        brandRepository.save(brand);
    }
    @Override
    public BrandDTO getBrand(Long id) {
        Brand brand = brandRepository
                .findById(id)
                .orElseThrow(() -> new BusinessServiceOperationException
                        .BrandNotFoundException("Brand not found"));
        return brandConverter.toBrandDTO(brand);
    }

    @Override
    public Collection<BrandDTO> getBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandConverter::toBrandDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Brand brand = brandRepository
                .findById(id)
                .orElseThrow(() -> new BusinessServiceOperationException
                        .BrandNotFoundException("Brand not found"));
        productRepository.deleteAllByBrand(brand);
        brandRepository.delete(brand);
    }
}
