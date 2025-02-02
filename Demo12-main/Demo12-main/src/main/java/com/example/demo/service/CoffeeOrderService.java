package com.example.demo.service;

import com.example.demo.model.CoffeeOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.demo.config.RabbitMQConfig.*;

@Service
public class CoffeeOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public CoffeeOrder createOrder(CoffeeOrder order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderTime(LocalDateTime.now());
        order.setStatus("PENDING");
        
        rabbitTemplate.convertAndSend(ORDER_EXCHANGE, ORDER_ROUTING_KEY, order);
        return order;
    }

    @RabbitListener(queues = ORDER_QUEUE)
    public void processOrder(CoffeeOrder order) {
        // 실제 환경에서는 여기서 주문 처리 로직 구현
        System.out.println("Processing order: " + order);
        try {
            Thread.sleep(5000); // 주문 처리 시뮬���이션
            System.out.println("Order completed: " + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 