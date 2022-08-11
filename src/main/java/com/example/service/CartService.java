package com.example.service;
import java.util.List;

import com.example.bean.Cart;

public interface CartService {
    public String saveCartItem(Cart c);
    
    public List<Cart> getAllCartItem();
   
    
}
