package com.micropos.carts.rest;

import com.micropos.carts.api.CartApi;
import com.micropos.carts.dto.ItemDto;
import com.micropos.carts.model.Cart;
import com.micropos.carts.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartsController implements CartApi {
    Cart cart;
    CartService cartService;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<Boolean> deleteProductInCart(String productId) {
        if (cartService.deleteProductInCart(cart, productId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public ResponseEntity<Boolean> emptyCart() {
        if (cartService.emptyCart(cart)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public ResponseEntity<List<ItemDto>> getCart() {
        return new ResponseEntity<>(new ArrayList<>(cartService.getCart(cart)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateProductInCart(String productId, Integer quantity) {
        if (cartService.updateProductInCart(cart, productId, quantity)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
