package com.example.demo.controller;

import com.example.demo.model.CoffeeOrder;
import com.example.demo.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coffee")
@CrossOrigin(origins = "http://localhost:3000")  // React 앱을 위한 CORS 설정
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @PostMapping("/order")
    public ResponseEntity<CoffeeOrder> createOrder(@RequestBody CoffeeOrder order) {
        CoffeeOrder createdOrder = coffeeOrderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("커피 주문 시스템이 정상적으로 동작중입니다.");
    }
} 