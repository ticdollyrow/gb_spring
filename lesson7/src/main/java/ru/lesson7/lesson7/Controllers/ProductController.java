package ru.lesson7.lesson7.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lesson7.lesson7.Model.Product;
import ru.lesson7.lesson7.Services.ProductService;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/products/between")
    public List<Product> findProductByPriceBetween(@RequestParam(defaultValue = "20.0") Float min, @RequestParam(defaultValue = "45.7") Float max){
        return productService.findByPriceBetween(min, max);
    }

    @PostMapping(path = "/products")
    public void create(@RequestBody Product newProduct) {
       productService.save(newProduct);
    }
}
