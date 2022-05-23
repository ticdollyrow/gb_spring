package ru.lesson7.lesson7.Services;


import org.springframework.stereotype.Service;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceBetween(Float min, Float max){
        return productRepository.findAllByCostBetween(min, max);
    }

    public void save(Product product){
        productRepository.save(product);
    }
}
