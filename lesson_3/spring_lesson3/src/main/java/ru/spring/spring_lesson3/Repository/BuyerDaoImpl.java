package ru.spring.spring_lesson3.Repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Buyer;
import ru.spring.spring_lesson3.SessionFactoryUtils;

import java.util.List;

@Component
public class BuyerDaoImpl implements BuyerDao{
    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;
    @Override
    public Buyer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public List<Buyer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("select u from Buyer u").getResultList();
            session.getTransaction().commit();
            return buyers;
        }
    }

    @Override
    public Buyer findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.createQuery("select u from Buyer u where u.name = :name", Buyer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public void save(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }
}
