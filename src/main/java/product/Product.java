package product;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id, String title, float cost){
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "product.Product{" + id + "title ='" + title +  " cost = " + cost + '\'' + '}';
    }
}
