package com.example.service.Impl;

import com.example.bean.Category;
import com.example.dao.CategoryDao;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao cd;
    @Override
    public String saveCategory(String cname) {
        if(!cd.existsByName(cname)) {
            Category cat = new Category(cname);
            cat = cd.saveAndFlush(cat);
            if(cat.getName() != null) {
                System.out.println("Category added to Database:" + cat);
                return "Category Added";
            }else
                return "Failed to add Category";
        }else

        return "Category already exists";
    }

    @Override
    public List<Category> showCategory() {
        List<Category> categories = cd.findAll();
        return categories;
    }
}
