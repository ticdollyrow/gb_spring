package lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {

    private List<Product> productList;
    private final  int COUNT = 5;
    private final static Random random = new Random();

    @PostConstruct
    public void init(){
        productList = new ArrayList<>() ;
        int id = 0;
        String title;
        float cost;
        for (int i = 0; i < COUNT; i++) {
            id += 1;
            cost =  random.nextFloat() * 100;
            title = String.valueOf(ProductTitle.values()[new Random().nextInt(ProductTitle.values().length)]);
            productList.add(new Product(id, title, cost));
        }
    }

   public List<Product> getProductList(){
        return productList;
   }

   public Product getProductById(int productId){
        return productList.stream()
                .filter(p -> p.getId() == productId)
                .findAny()
                .orElse(null);
   }
}
