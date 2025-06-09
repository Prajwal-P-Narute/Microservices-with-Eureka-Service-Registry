package com.micro.OrderService.controller;

import com.micro.OrderService.entity.OrderDetails;
import com.micro.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDetails orderDetails){
        boolean orderInfo = orderService.createOrder(orderDetails);

        if(orderInfo){
            return new ResponseEntity<>("Order generated Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Order is not generated due to some error", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){

        Optional<OrderDetails> order = orderService.getOrder(id);
        order.ifPresentOrElse(
                u -> System.out.println("Found order: " + u),
                () -> System.out.println("Order with id " + id + " not found")
        );

        if(order.isPresent()){
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with id " +id+" is not Present");
    }
}
