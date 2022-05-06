package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.Brand;
import org.patikadev.orderexample.model.Category;
import org.patikadev.orderexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Collection<Product> findProductByIsDeleted(boolean isDeleted);
    void deleteAllByCategory(Category category);
    void deleteAllByBrand(Brand brand);
    Product getProductByName(String name);
}
