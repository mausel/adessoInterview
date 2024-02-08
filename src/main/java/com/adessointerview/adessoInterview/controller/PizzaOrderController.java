package com.adessointerview.adessoInterview.controller;

import com.adessointerview.adessoInterview.domain.PizzaOrder;
import com.adessointerview.adessoInterview.service.PizzaOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PizzaOrderController {

    @Autowired
    private PizzaOrderService pizzaOrderService;

    @GetMapping
    @Operation(
            summary = "Retrieve all orders",
            description = "Retrieve all orders available in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    public List<PizzaOrder> getAllOrders(){
        return pizzaOrderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    @Operation(
            summary = "Find order by ID",
            description = "Find specific order by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "No existing order found with provided ID")
            }
    )
    public PizzaOrder getOrderById(@PathVariable String orderId){
        return pizzaOrderService.getOrderById(orderId);
    }

    @PostMapping
    @Operation(
            summary = "Place new order",
            description = "Place new order",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order created"),
                    @ApiResponse(responseCode = "400", description = "Body was invalid")
            }
    )
    public PizzaOrder placeOrder(@RequestBody PizzaOrder pizzaOrder){
        return pizzaOrderService.placeOrder(pizzaOrder);
    }

    @PostMapping("{orderId}/take")
    @Operation(
            summary = "Status from Pending to In Progress",
            description = "Update order status from Pending to In Progress",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "No existing order found with provided ID")
            }
    )
    public void takeOrder(@PathVariable String orderId){
        pizzaOrderService.takeOrder(orderId);
    }

    @PostMapping("/{orderId}/complete")
    @Operation(
            summary = "Status from In Progress to Completed",
            description = "Update order status from In Progress to Completed",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "No existing order found with provided ID")
            }
    )
    public void completeOrder(@PathVariable String orderId){
        pizzaOrderService.completeOrder(orderId);
    }

    @PutMapping("/{orderId}")
    @Operation(
            summary = "Update order informations",
            description = "Update order by changing its informations",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Body was invalid"),
                    @ApiResponse(responseCode = "404", description = "No existing order found with provided ID")
            }
    )
    public PizzaOrder updateOrder(@PathVariable String orderId, @RequestBody PizzaOrder order){
        return pizzaOrderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/{orderId}")
    @Operation(
            summary = "Delete order",
            description = "Delete order by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "No existing order found with provided ID")
            }
    )
    public void deleteOrder(@PathVariable String orderId){
        pizzaOrderService.deleteOrder(orderId);
    }
}
