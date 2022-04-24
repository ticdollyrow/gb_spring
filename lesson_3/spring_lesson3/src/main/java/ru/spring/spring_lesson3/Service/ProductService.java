package ru.spring.spring_lesson3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getById(Long id){
        return productRepository.getById(id);
    }

    public List<Product> getAll(){
        return productRepository.getAllProduct();
    }

    public void addProduct(Long id, String title, Float cost){
        productRepository.addProduct(id, title, cost);
    }

    public void add(Product product){
        productRepository.add(product);
    }

}
