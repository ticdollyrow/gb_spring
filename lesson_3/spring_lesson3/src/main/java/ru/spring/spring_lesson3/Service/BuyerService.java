package ru.spring.spring_lesson3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Buyer;
import ru.spring.spring_lesson3.Repository.BuyerDaoImpl;

import java.util.List;

@Component
public class BuyerService {

    @Autowired
    private BuyerDaoImpl buyerDao;

    public Buyer getById(Long id){
        return buyerDao.findById(id);
    }

    public List<Buyer> getAll(){
        return buyerDao.findAll();
    }
}
