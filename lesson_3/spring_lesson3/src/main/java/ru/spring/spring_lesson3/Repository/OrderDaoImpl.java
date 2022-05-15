package ru.spring.spring_lesson3.Repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Buyer;
import ru.spring.spring_lesson3.Model.Order;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.SessionFactoryUtils;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;
    @Override
    public List<Product> getProducts() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Order order = session.get(Order.class, 1L);
            List<Product> products = order.getProducts();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Buyer> getBuyers() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Order order = session.get(Order.class, 2L);
            List<Buyer> buyers = order.getBuyers();
            session.getTransaction().commit();
            return buyers;
        }
    }

    public List<Order> findAll(){
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Order> orders = session.createQuery("select u from Order u").getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }
}
