package ru.spring.spring_lesson3.Repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.SessionFactoryUtils;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("select u from Product u").getResultList();;
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.createQuery("select u from Product u where u.name = :name", Product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
