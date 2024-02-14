package com.sameer.restaurant.cloudkitchen.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int orderId;
    private String customerName;
    private String phoneNumber;
    private List<String> foodOrder;
    private String address;
}
