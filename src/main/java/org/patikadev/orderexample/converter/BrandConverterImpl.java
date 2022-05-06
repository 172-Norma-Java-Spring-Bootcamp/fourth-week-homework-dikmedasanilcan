package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.BrandDTO;
import org.patikadev.orderexample.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverterImpl implements BrandConverter {
    @Override
    public Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brand.setImage(brandDTO.getImage());
        return brand;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO(brand.getName(), brand.getImage());
    }
}
