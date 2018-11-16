package cn.chings.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Value("${test.a}")
    public String a;

    @Value("${test.b}")
    public boolean b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
