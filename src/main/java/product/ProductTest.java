package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductTest {
    private final static Random random = new Random();

    public static List<Product> listOfProduct(int count){
        List<Product> list = new ArrayList<>() ;
        int id = 0;
        String title;
        float cost;

        for(int i = 0; i < count; i++){
            id += 1;
            cost =  random.nextFloat() * 10;
            title = String.valueOf(ProductTitle.values()[new Random().nextInt(ProductTitle.values().length)]);
            list.add(new Product(id, title, cost));
        }
        return list;
    }
}
