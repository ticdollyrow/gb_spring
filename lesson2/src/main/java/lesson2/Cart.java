package lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    @Autowired
    private ProductRepository productRepository;
    private List<Product> cartList;

    @PostConstruct
    public void init(){
        cartList = new ArrayList<>();
    }

    public void addById(int productId){
        cartList.add(productRepository.getProductById(productId));
    }

    public void delete(int productId){
        cartList.removeIf(p -> p.getId() == productId);
    }

    public void print(){
        System.out.println(cartList.toString());
    }
}
