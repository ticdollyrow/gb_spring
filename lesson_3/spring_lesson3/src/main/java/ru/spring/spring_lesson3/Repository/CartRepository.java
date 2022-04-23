package ru.spring.spring_lesson3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartRepository {
    @Autowired
    private ProductService productService;
    private List<Product> cartList;


    @PostConstruct
    public void init(){
        cartList = new ArrayList<>();
    }
    public List<Product> getCartList(){
        return cartList;
    }

    public void addToCart(Long id){
        cartList.add(productService.getById(id));
    }

    public void delete(Long id){
        cartList.removeIf(p -> p.getId().equals(id));
    }

}
