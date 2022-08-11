package com.example.service.Impl;

import com.example.bean.Cart;
import com.example.bean.Product;
import com.example.dao.CartDao;
import com.example.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cd;

    @Override
    public String saveCartItem(Cart c) {
        Cart cart= cd.saveAndFlush(c);
        if(cart.getProductName() != null)
            return "Item Added to Cart";
        else
            return "Error adding Item to cart";
    }
    
    @Override
    public List<Cart> getAllCartItem() {
        List<Cart> Cart = cd.findAll();
        return Cart;
    }
    
}
