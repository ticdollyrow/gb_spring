package ru.spring.spring_lesson3.Repository;

import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Model.ProductTitle;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
    private static final int COUNT = 10;
    private final static Random random = new Random();

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        Long id = 0l;
        String title;
        Float cost;
        for (int i = 0; i < COUNT; i++) {
            id += 1l;
            cost =  random.nextFloat() * 100;
            title = String.valueOf(ProductTitle.values()[new Random().nextInt(ProductTitle.values().length)]);
            products.add(new Product(id, title, cost));
        }
    }

    public List<Product> getAllProduct(){
        return Collections.unmodifiableList(products);
    }

    public Product getById(Long id){
        return products.stream().filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void addProduct(Long id, String title, Float cost){
        products.add(new Product(id, title, cost));
    }

    public void add(Product product){
        products.add(product);
    }
}
