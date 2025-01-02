package com.payment.gateway.api.Model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentInfo {

    @Value("0")
    public int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
