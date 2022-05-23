package ru.lesson7.lesson7.Services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Repositories.ProductRepository;
import ru.lesson7.lesson7.Repositories.Specification.ProductSpecification;

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

    public ResponseEntity<?> save(Product product){
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Page<Product> findProducts(Integer p, Float maxPrice, Float minPrice){
        Specification<Product> spec = Specification.where(null);

        if(minPrice != null){
            spec = spec.and(ProductSpecification.costGreaterOrElseThan(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecification.costLessThanOrEqualTo(maxPrice));
        }

        return productRepository.findAll(spec, PageRequest.of(p -1, 5));
    }
}
