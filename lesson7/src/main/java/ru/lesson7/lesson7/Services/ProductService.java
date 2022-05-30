package ru.lesson7.lesson7.Services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.lesson7.lesson7.Converters.ProductConverter;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Exceptions.ResourceNotFoundExeption;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Repositories.ProductRepository;
import ru.lesson7.lesson7.Repositories.Specification.ProductSpecification;
import ru.lesson7.lesson7.Validators.ProductValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceBetween(Float min, Float max){
        return productRepository.findAllByCostBetween(min, max);
    }

    public ResponseEntity<?> save(ProductDto productDto){
        productValidator.validate(productDto);
        productRepository.save(productConverter.dtoToEntity(productDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Page<Product> findProducts(Integer p, Float maxPrice, Float minPrice){
        Specification<Product> spec = Specification.where(null);

        if(minPrice != null){
            spec = spec.and(ProductSpecification.costGreaterOrElseThan(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecification.costLessThanOrEqualTo(maxPrice));
        }

        return productRepository.findAll(spec, PageRequest.of(p -1, 5));
    }

    public List<Product> filterProducts(Float minPrice, Float maxPrice){
        Specification<Product> spec = Specification.where(null);

        if(minPrice != null){
            spec = spec.and(ProductSpecification.costGreaterOrElseThan(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecification.costLessThanOrEqualTo(maxPrice));
        }

        return productRepository.findAll(spec);
    }
    @Transactional
    public void updateProduct(ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundExeption("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        product.setCost(productDto.getCost());
        product.setTitle(productDto.getTitle());
    }
}
