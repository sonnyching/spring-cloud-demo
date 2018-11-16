package cn.chings.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

//    @Autowired
//    RestTemplate template;

    @Autowired
    ProviderFeign provider;

    @HystrixCommand(fallbackMethod = "defaultString")
    public String proxy(){

        return secondCall();

    }

    public String secondCall(){
       /* try{
            System.out.println("休眠了10000毫秒");
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/

       return provider.getString();

//        return template.exchange("http://app-provider/getStr", HttpMethod.GET,null,String.class).getBody();

    }

    public String defaultString(){
        return "this is a default method string";
    }






}
