package cn.chings.provider.controller;

import cn.chings.provider.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    Service service;

    @GetMapping("/")
    public void request(){
        System.out.println(" hi, i am provider!");
    }

    @GetMapping("/getStr")
    public String getString(){

        System.out.println(service.customer());

        return " i am provider";
    }

}
