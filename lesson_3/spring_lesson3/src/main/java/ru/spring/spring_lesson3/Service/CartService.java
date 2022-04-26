package ru.spring.spring_lesson3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Repository.CartRepository;

import java.util.List;

@Component
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Product> showCart(){
        return cartRepository.getCartList();
    }

    public void  addProductToCart(Long id){
        cartRepository.addToCart(id);
    }

    public void delete(Long id){
        cartRepository.delete(id);
    }
}
