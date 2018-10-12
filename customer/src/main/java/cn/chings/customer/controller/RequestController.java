package cn.chings.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class RequestController {

    @GetMapping("/")
    public void request(){
        System.out.println(" hi, i am customer!");
    }

}
