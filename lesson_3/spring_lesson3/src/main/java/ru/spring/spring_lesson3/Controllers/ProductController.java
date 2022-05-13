package ru.spring.spring_lesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Repository.ProductDaoImpl;


import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDaoImpl productDao;

    @GetMapping("/productdao/all")
    @ResponseBody
    public List<Product> getAll(){
        return productDao.findAll();
    }


    @GetMapping("/productdao/{id}")
    @ResponseBody
    public Product getById(@PathVariable Long id){

        return  productDao.findById(id);

    }
}
