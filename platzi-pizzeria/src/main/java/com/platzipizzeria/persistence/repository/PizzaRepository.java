package com.platzipizzeria.persistence.repository;

import com.platzipizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
   List<PizzaEntity> findAllByAvaliableTrueOrderByPrice();
   PizzaEntity findAllByAvaliableFalseOrderByPrice(String name);
}
