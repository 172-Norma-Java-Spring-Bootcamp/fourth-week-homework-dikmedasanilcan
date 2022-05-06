package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand getBrandByName(String name);

}
