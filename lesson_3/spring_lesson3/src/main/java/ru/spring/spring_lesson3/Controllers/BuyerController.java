package ru.spring.spring_lesson3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.spring_lesson3.Model.Buyer;
import ru.spring.spring_lesson3.Service.BuyerService;

import java.util.List;

@Controller
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyer/all")
    @ResponseBody
    public List<Buyer> getAll(){
        return buyerService.getAll();
    }
}
