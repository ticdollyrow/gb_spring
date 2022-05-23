package ru.lesson7.lesson7.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lesson7.lesson7.Model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostBetween(Float min, Float max);
}
