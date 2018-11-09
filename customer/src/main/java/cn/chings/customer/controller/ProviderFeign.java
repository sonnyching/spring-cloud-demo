package cn.chings.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("app-provider")
public interface ProviderFeign {

    @RequestMapping(method = RequestMethod.GET,value = "/getStr")
    public String getString();

}
