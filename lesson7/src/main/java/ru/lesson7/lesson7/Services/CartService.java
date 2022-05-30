package ru.lesson7.lesson7.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lesson7.lesson7.DTO.ProductDto;
import ru.lesson7.lesson7.Repositories.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public List<ProductDto> getCartList(){
        return  cartRepository.getCartList();
    }

    public void addToCartList(Long id){
        cartRepository.addToCart(id);
    }

    public void deleteFromCartList(Long id){
        cartRepository.delete(id);
    }
}
