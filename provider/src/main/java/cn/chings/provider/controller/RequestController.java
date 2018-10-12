package cn.chings.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/provider")
public class RequestController {

    @GetMapping("/")
    public void request(){
        System.out.println(" hi, i am provider!");
    }

}
