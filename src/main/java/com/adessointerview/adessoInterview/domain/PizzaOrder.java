package com.adessointerview.adessoInterview.domain;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
public class PizzaOrder {
    private String orderId;
    private String customerName;
    private String customerAddess;
    private List<Pizza> pizzas;
    private double total;
    private String status;
    private Date orderTime;

    public PizzaOrder(){
        this.orderId = UUID.randomUUID().toString();
        this.orderTime = new Date();
    }
}


