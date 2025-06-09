package com.micro.OrderService.service;

import com.micro.OrderService.entity.OrderDetails;
import com.micro.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public boolean createOrder(OrderDetails orderDetails) {

        OrderDetails orderDetails1 = orderRepository.save(orderDetails);

        if(orderDetails1.getOrderId() != null){
            return true;
        }
        return false;

    }

    public Optional<OrderDetails> getOrder(Integer id) {

       Optional<OrderDetails> order =  orderRepository.findById(id);

       return order;
    }
}
