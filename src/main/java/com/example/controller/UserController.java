package com.example.controller;

import com.example.bean.Cart;
import com.example.bean.Product;
import com.example.bean.User;
import com.example.service.CartService;
import com.example.service.ProductService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService us;
    
    @Autowired
    private ProductService ps;
    
    @Autowired
    private CartService cs;

    @GetMapping(value = "/userSignUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping(value = "/registerUser")
    @ResponseBody
    public String storeUser(HttpServletRequest request){
       String name = request.getParameter("name");
       int age = Integer.parseInt(request.getParameter("age"));
       String gender = request.getParameter("gender");
       String email = request.getParameter("email");
       String pwd = request.getParameter("password");
       User u= new User(name,age,gender,email,pwd);
       String output= us.saveSignUpInfo(u);
       return output;

    }
    
    @GetMapping(value = "/addtocart")
    public String addToCart(ModelMap map,@RequestParam(value="Id",required=true) int ProductId){
    	Product prod=ps.getProduct(ProductId);
    	String result = cs.saveCartItem(new Cart(prod.getProductName(),1,prod.getProductPrice(),prod.getFilePath()) );
    	map.addAttribute("cart",cs.getAllCartItem());
        return "cart";
    }
    
    @GetMapping(value = "/checkOut")
    public String checkOut(ModelMap map){
    	map.addAttribute("cart",cs.getAllCartItem());
        return "cart";
    }
    
    
}
