package cn.chings.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("app-gateway")
public interface CustomerFeign {

    @RequestMapping(value = "/api/customer/hello" ,method = RequestMethod.GET)
    public String hello();

}
