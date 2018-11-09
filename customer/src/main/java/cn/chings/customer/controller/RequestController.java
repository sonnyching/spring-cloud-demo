package cn.chings.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class RequestController {

//    @Autowired
//    ProviderFeign feign;
    @Autowired
    Service service;

    @GetMapping("/")
    public void request(){
        String s = service.proxy();
        System.out.println(s);

    }

}
