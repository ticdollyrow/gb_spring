package ru.spring.spring_lesson3.Repository;

import ru.spring.spring_lesson3.Model.Buyer;
import ru.spring.spring_lesson3.Model.Order;
import ru.spring.spring_lesson3.Model.Product;

import java.util.List;

public interface OrderDao {

    List<Order> findAll();
    List<Product> getProducts();
    List<Buyer>   getBuyers();
}
