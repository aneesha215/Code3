package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(int id,String name) {
        this.name = name;
        this.id=id;
    }
    public Category(){

    }

    public String getName() {
        return name;
    }
}
