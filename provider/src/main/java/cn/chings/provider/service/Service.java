package cn.chings.provider.service;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    CustomerFeign customer;

    public String customer(){
        return customer.hello();
    }

}
