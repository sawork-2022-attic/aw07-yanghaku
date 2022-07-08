package com.micropos.order.rest;

import com.micropos.order.mapper.ItemMapper;
import com.micropos.order.model.Cart;
import com.micropos.order.model.Item;
import com.micropos.order.api.OrderApi;
import com.micropos.order.dto.ItemDto;
import com.micropos.order.dto.OrderDto;
import com.micropos.order.mapper.OrderMapper;
import com.micropos.order.model.Order;
import com.micropos.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController implements OrderApi {

    OrderService orderService;

    OrderMapper orderMapper;

    ItemMapper itemMapper;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public ResponseEntity<OrderDto> addOrder(List<ItemDto> items) {
        Cart cart = new Cart();
        cart.setItems((List<Item>) itemMapper.toCart(items));
        Order order = orderService.addOrder(cart);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(orderMapper.toOrderDto(order), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<OrderDto> deliverOrderById(Integer orderId) {
        Order order = orderService.deliverOrder(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(orderMapper.toOrderDto(order), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<OrderDto> getOrderById(Integer orderId) {
        Order order = orderService.getOrder(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(orderMapper.toOrderDto(order), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<OrderDto>> allOrders() {
        Collection<Order> orders = orderService.getAllOrder();
        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>((List<OrderDto>) orderMapper.toOrdersDto(orders), HttpStatus.OK);
        }
    }
}
