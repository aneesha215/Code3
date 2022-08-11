package com.example.service.Impl;

import com.example.bean.Category;
import com.example.bean.Product;
import com.example.dao.ProductDao;
import com.example.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao pd;

    @Override
    public String saveProduct(Product p) {
        Product pro= pd.saveAndFlush(p);
        if(pro.getProductName() != null)
            return "Product Saved";
        else
            return "Product Not Saved";
    }
    
    @Override
    public List<Product> getAllProducts() {
        List<Product> Product = pd.findAll();
        return Product;
    }
    @Override
    public Product getProduct(int prodId) {
    	return pd.getById(prodId);
    	
    }
}
