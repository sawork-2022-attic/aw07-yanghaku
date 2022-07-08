package com.micropos.carts.service.impl;

import com.micropos.carts.dto.ItemDto;
import com.micropos.carts.mapper.CartsMapper;
import com.micropos.carts.model.Cart;
import com.micropos.carts.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CartServiceImpl implements CartService {
    private CartsMapper cartsMapper;

    @Autowired
    public void setCartsMapper(CartsMapper cartsMapper) {
        this.cartsMapper = cartsMapper;
    }

    @Override
    public boolean deleteProductInCart(Cart cart, String productId) {
        return false;
    }

    @Override
    public boolean emptyCart(Cart cart) {
        return false;
    }

    @Override
    public boolean updateProductInCart(Cart cart, String productId, Integer quantity) {
        return false;
    }

    @Override
    public Collection<ItemDto> getCart(Cart cart) {
        return cartsMapper.toCartDto(cart.getItems());
    }
}
