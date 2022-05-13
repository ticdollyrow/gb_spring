package ru.spring.spring_lesson3.Repository;

import ru.spring.spring_lesson3.Model.Buyer;

import java.util.List;

public interface BuyerDao {

    Buyer findById(Long id);

    List<Buyer> findAll();

    Buyer findByName(String name);

    void save(Buyer buyer);

}
