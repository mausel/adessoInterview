package com.adessointerview.adessoInterview.service.impl;

import com.adessointerview.adessoInterview.domain.Pizza;
import com.adessointerview.adessoInterview.domain.PizzaOrder;
import com.adessointerview.adessoInterview.service.PizzaOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {

    private List<PizzaOrder> orders = new ArrayList<>();


    @Override
    public List<PizzaOrder> getAllOrders() {
        return orders;
    }

    @Override
    public PizzaOrder getOrderById(String orderId) {
        for(PizzaOrder order : orders){
            if(order.getOrderId().equals(orderId)){
                return order;
            }
        }
        return null;
    }

    @Override
    public PizzaOrder placeOrder(PizzaOrder pizzaOrder) {
        calculateTotal(pizzaOrder);
        pizzaOrder.setStatus("Pending");
        orders.add(pizzaOrder);
        return pizzaOrder;
    }

    @Override
    public void takeOrder(String orderId){
        PizzaOrder order = getOrderById(orderId);
        if(order != null && order.getStatus().equals("Pending")){
            order.setStatus("In Progress");
        }
    }

    @Override
    public void completeOrder(String orderId) {
        PizzaOrder order = getOrderById(orderId);
        if(order != null && order.getStatus().equals("In Progress")){
            order.setStatus("Completed");
        }
    }

    @Override
    public PizzaOrder updateOrder(String orderId, PizzaOrder order) {
        PizzaOrder existingOrder = getOrderById(orderId);
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setCustomerName(order.getCustomerAddess());
        existingOrder.setPizzas(order.getPizzas());
        existingOrder.setTotal(order.getTotal());
        existingOrder.setStatus(order.getStatus());
        return existingOrder;
    }

    @Override
    public void deleteOrder(String orderId) {
        orders.removeIf(order -> order.getOrderId().equals(orderId));
    }

    private void calculateTotal(PizzaOrder pizzaOrder){
        double total = 0;
        for(Pizza pizza : pizzaOrder.getPizzas()){
            total += pizza.getPrice();
        }
        pizzaOrder.setTotal(total);
    }


}
