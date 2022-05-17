package ru.spring.spring_lesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.spring_lesson3.Model.Order;
import ru.spring.spring_lesson3.Model.Product;
import ru.spring.spring_lesson3.Repository.OrderDaoImpl;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderDaoImpl orderDao;

    @GetMapping("/order/product")
    @ResponseBody
    public List<Product> getProducts(){
        return orderDao.getProducts();
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> getOrders(){
        return orderDao.findAll();
    }
}
