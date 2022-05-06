package org.patikadev.orderexample.service.implementation;

import lombok.RequiredArgsConstructor;
import org.patikadev.orderexample.converter.CategoryConverter;
import org.patikadev.orderexample.dto.CreateCategoryRequestDTO;
import org.patikadev.orderexample.dto.GetCategoryResponseDTO;
import org.patikadev.orderexample.exception.BaseException;
import org.patikadev.orderexample.exception.BusinessServiceOperationException;
import org.patikadev.orderexample.model.Category;
import org.patikadev.orderexample.repository.CategoryRepository;
import org.patikadev.orderexample.repository.ProductRepository;
import org.patikadev.orderexample.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryConverter categoryConverter;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public void create(CreateCategoryRequestDTO createCategoryRequestDTO) {
       Category category = categoryConverter.toCategory(createCategoryRequestDTO);
        if(categoryRepository.getCategoryByName(createCategoryRequestDTO.getName())!=null){
            throw new BusinessServiceOperationException.CategoryAlreadyHave("Category already have in categories");
        }
       if(categoryRepository.getCategoryByName(category.getName())==null){
           Category parent = findParent(category);
           if(parent==null){
               categoryRepository.save(category);
               return;
           }
           category.setParent(parent);
           categoryRepository.save(category);
       }
       categoryRepository.save(category);
    }

    @Override
    public CreateCategoryRequestDTO getCategory(Long id) throws BaseException {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new BusinessServiceOperationException.CategoryNotFoundException("Category not found"));
        return categoryConverter.toCreateCategoryRequestDTO(category);
    }

    @Override
    public Collection<GetCategoryResponseDTO> getCategories() {
       return categoryRepository.findAll()
               .stream()
               .map(categoryConverter::toGetCategoryResponseDto)
               .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws BaseException {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new BusinessServiceOperationException.CategoryNotFoundException("Category not found"));
        productRepository.deleteAllByCategory(category);
        categoryRepository.delete(category);

    }

    private Category findParent(Category category){
        if(Objects.isNull(category)) return null;
        Category categoryByName = categoryRepository.getCategoryByName(category.getName());
        if(categoryByName!=null) {
            return categoryByName;
        }
        return findParent(category.getParent());
    }

}
