package ru.lesson7.lesson7.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lesson7.lesson7.Model.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private Float cost;

    public ProductDto(Product product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
