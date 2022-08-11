package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int productCount;
    private int productPrice;
    private String filePath;
    private String Category;
    
    
    public int getProductPrice() {
		return productPrice;
	}

	public Product() {
		
	}

	public Product(String productName,int productCount,int productPrice,String path,String Category) {
    	this.productName=productName;
    	this.productCount=productCount;
    	this.productPrice=productPrice;
    	this.Category=Category;
        filePath=path;
    }
    public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}


	public int getProductCount() {
		return productCount;
	}

	public String getCategory() {
		return Category;
	}

	public String getFilePath() {
		return filePath;
	}
  
    
}
