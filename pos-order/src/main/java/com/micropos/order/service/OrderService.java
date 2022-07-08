package com.micropos.order.service;

import com.micropos.order.model.Cart;
import com.micropos.order.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();

    Order addOrder(Cart cart);

    Order getOrder(Integer id);

    Order deliverOrder(Integer id);
}
