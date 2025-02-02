package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CoffeeOrder {
    private String orderId;
    private String customerName;
    private String coffeeName;
    private String size;
    private int quantity;
    private String status;
    private LocalDateTime orderTime;
} 