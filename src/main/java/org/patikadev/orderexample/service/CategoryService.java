package org.patikadev.orderexample.service;

import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.dto.GetCategoryResponseDTO;
import org.patikadev.orderexample.exception.BaseException;

import java.util.Collection;

public interface CategoryService {
    void create(CreateCategoryRequestDTO createCategoryRequestDTO);
    CreateCategoryRequestDTO getCategory(Long id) throws BaseException;
    Collection<GetCategoryResponseDTO> getCategories();
    void delete(Long id) throws BaseException;

}
