package cn.chings.customer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("app-provider")
@FeignClient("app-gateway")
public interface ProviderFeign {

    @RequestMapping(method = RequestMethod.GET,value = "/api/provider/getStr")
    public String getString();

}
