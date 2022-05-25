package ru.lesson7.lesson7.Converters;

import org.springframework.stereotype.Component;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Model.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product);
    }
}
