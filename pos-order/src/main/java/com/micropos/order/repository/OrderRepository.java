package com.micropos.order.repository;

import com.micropos.order.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    Order findById(Integer id);

    Order addOrder(Order order);

    boolean deleteOrder(Integer id);
}
