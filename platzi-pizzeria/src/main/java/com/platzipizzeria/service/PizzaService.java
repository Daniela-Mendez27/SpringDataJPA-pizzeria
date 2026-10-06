package com.platzipizzeria.service;

import com.platzipizzeria.persistence.entity.PizzaEntity;
import com.platzipizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvaliable() {
        return this.pizzaRepository.findAllByAvaliableTrueOrderByPrice();
    }

    public PizzaEntity getByName(String name) {
        return this.pizzaRepository.findAllByAvaliableFalseOrderByPrice(name);
    }


    //solo muestra un registro
    public PizzaEntity get(int idPizza) {

        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public void delete(int idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean exists(int idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }


}