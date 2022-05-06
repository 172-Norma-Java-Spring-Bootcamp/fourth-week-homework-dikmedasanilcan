package org.patikadev.orderexample.converter;

import org.patikadev.orderexample.dto.BrandDTO;
import org.patikadev.orderexample.model.Brand;

public interface BrandConverter {
    Brand toBrand(BrandDTO brandDTO);
    BrandDTO toBrandDTO(Brand brand);
}
