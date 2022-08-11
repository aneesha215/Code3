package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int productQty;
    private int productPrice;
    private String filePath;
    
    
    public int getProductPrice() {
		return productPrice;
	}

	public Cart() {
		
	}

	public Cart(String productName,int productQty,int productPrice,String path) {
    	this.productName=productName;
    	this.productQty=productQty;
    	this.productPrice=productPrice;
        filePath=path;
    }
    public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}


	public int getProductQty() {
		return productQty;
	}


	public String getFilePath() {
		return filePath;
	}
  
    
}
