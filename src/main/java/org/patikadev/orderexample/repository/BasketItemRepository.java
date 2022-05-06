package org.patikadev.orderexample.repository;

import org.patikadev.orderexample.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {
    Collection<BasketItem> findAllByBasketId(Long id);

}
