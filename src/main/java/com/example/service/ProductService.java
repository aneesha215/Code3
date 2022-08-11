package com.example.service;

import java.util.List;

import com.example.bean.Product;

public interface ProductService {
    public String saveProduct(Product p);
    
    public List<Product> getAllProducts();
    
    public Product getProduct(int prodId);
    
}
