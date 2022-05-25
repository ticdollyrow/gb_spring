package ru.lesson7.lesson7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lesson7.lesson7.Converters.ProductConverter;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Services.ProductService;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return productConverter.entityToDto(productService.findById(id));
    }

    @GetMapping("")
    public List<ProductDto> findAllProducts(){
        return productService.getAllProducts().stream().map(productConverter::entityToDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }


    @GetMapping("/filter")
    public List<ProductDto> filterProduct(@RequestParam(required = false ) Float min, @RequestParam( required = false) Float max){
        return productService.filterProducts(min, max).stream().map(productConverter::entityToDto).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<?>  create(@RequestBody ProductDto newProductDto) {
      return productService.save(productConverter.dtoToEntity(newProductDto));
    }

    @GetMapping("/page")
    public Page<ProductDto> getProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                     @RequestParam(name = "min_price", required = false) Float minPrice,
                                     @RequestParam(name = "max_price", required = false) Float maxPrice

    ) {
        if(page < 1){
            page = 1;
        }
        return productService.findProducts(page, maxPrice, minPrice).map(
                p -> productConverter.entityToDto(p)
        );
    }
}
