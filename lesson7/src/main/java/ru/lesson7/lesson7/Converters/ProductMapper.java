package ru.lesson7.lesson7.Converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Model.Product;

public interface ProductMapper {
    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);
    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);
}
