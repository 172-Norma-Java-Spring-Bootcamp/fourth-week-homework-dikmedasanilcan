package org.patikadev.orderexample.service;

import org.patikadev.orderexample.dto.BrandDTO;

import java.util.Collection;

public interface BrandService {
    void create(BrandDTO brandDTO);
    BrandDTO getBrand(Long id);
    Collection<BrandDTO> getBrands();
    void delete(Long id);
}
