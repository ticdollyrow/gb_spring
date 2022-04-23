package ru.spring.spring_lesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.spring_lesson3.Service.ProductService;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable Long id){

        model.addAttribute("product", productService.getById(id));
        return "product";
    }

    @GetMapping("/products")
    public String getProduct(Model model){

        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "TEST";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
}
