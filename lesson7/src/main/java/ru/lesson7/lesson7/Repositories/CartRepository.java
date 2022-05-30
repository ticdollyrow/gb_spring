package ru.lesson7.lesson7.Repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lesson7.lesson7.Converters.ProductConverter;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartRepository {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductConverter productConverter;
    private List<ProductDto> cartList;

    @PostConstruct
    public void init(){
        cartList = new ArrayList<>();
    }

    public List<ProductDto> getCartList(){
        return cartList;
    }

    public void addToCart(Long id){
        Product product = productService.findById(id);
        cartList.add(productConverter.entityToDto(product));
    }

    public void delete(Long id){
        cartList.removeIf(p -> p.getId().equals(id));
    }
}
