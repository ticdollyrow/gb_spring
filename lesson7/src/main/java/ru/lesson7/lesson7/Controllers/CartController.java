package ru.lesson7.lesson7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lesson7.lesson7.Converters.ProductConverter;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Services.CartService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
   private final CartService cartService;
   private final ProductConverter productConverter;

   @GetMapping("")
   public List<ProductDto> showCart(){
      return cartService.getCartList();
   }

   @GetMapping("/{id}")
   public void addToCart(@PathVariable Long id){
      cartService.addToCartList(id);
   }

   @GetMapping("/del/{id}")
   public void deleteFromCart(@PathVariable Long id){
      cartService.deleteFromCartList(id);
   }
}
