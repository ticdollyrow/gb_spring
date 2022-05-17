package ru.spring.spring_lesson3.Repository;

import ru.spring.spring_lesson3.Model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    Product findByTitle(String title);

    void save(Product product);
}
