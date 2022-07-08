package com.micropos.delivery;

import com.micropos.order.model.Order;

import java.util.function.Consumer;

public class OrderDelivery implements Consumer<Order> {
    @Override
    public void accept(Order order) {
        System.out.println("delivery order " + order);
    }
}
