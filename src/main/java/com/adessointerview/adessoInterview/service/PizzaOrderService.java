package com.adessointerview.adessoInterview.service;

import com.adessointerview.adessoInterview.domain.PizzaOrder;

import java.util.List;

public interface PizzaOrderService {

    public List<PizzaOrder> getAllOrders();
    public PizzaOrder getOrderById(String orderId);
    public PizzaOrder placeOrder(PizzaOrder pizzaOrder);
    public void takeOrder(String orderId);
    public void completeOrder(String orderId);
    public PizzaOrder updateOrder(String orderId, PizzaOrder order);
    void deleteOrder(String orderId);

}
