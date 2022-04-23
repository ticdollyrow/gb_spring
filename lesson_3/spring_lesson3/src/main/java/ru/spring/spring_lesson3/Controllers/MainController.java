package ru.spring.spring_lesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.spring_lesson3.Service.CartService;
import ru.spring.spring_lesson3.Service.ProductService;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

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

    @GetMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("cartList", cartService.showCart());
        return "cartList";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(Model model, @PathVariable Long id){
        cartService.addProductToCart(id);
        model.addAttribute("cartList", cartService.showCart());
        return "cartList";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id){
        cartService.delete(id);
        model.addAttribute("cartList", cartService.showCart());
        return "cartList";
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
