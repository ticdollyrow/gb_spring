package ru.lesson7.lesson7.Controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Services.ProductService;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("")
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }


    @GetMapping("/filter")
    public List<Product> filterProduct(@RequestParam(required = false ) Float min, @RequestParam( required = false) Float max){
        return productService.filterProducts(min, max);
    }

    @PostMapping()
    public ResponseEntity<?>  create(@RequestBody Product newProduct) {
      return productService.save(newProduct);
    }

    @GetMapping("/page")
    public Page<Product> getProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                     @RequestParam(name = "min_price", required = false) Float minPrice,
                                     @RequestParam(name = "max_price", required = false) Float maxPrice

    ) {
        if(page < 1){
            page = 1;
        }
        return productService.findProducts(page, maxPrice, minPrice);
    }
}
