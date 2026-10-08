package com.platzipizzeria.persistence.repository;

import com.platzipizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

   // Corregido: Available con 'a-i'
   List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

   // Retorna Optional para que funcione .orElseThrow() en el Service
   Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

   List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

   List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

   List<PizzaEntity> findTop3ByAvailableTueAndPriceLessThanOrderByPriceAcs(double price);

   int countByVeganTrue();
}