package com.example.demo.pojo.order.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
