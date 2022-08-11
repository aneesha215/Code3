package com.example.controller;

import com.example.bean.Category;
import com.example.bean.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private CategoryService cs;

    @Autowired
    private ProductService ps;

    private String currentDirectory = System.getProperty("user.dir");


    private static String UPLOAD_FOLDER = "//Users//aneeshaafra//Downloads//Shoe-Portal//pictures";

    @GetMapping(value = "/welcome")
    @ResponseBody
    public String getLandingPage(){
        return "Welcome to Spring Boot App";
    }

    @GetMapping(value = "/login")
    public String adminLoginPage(){
        return "Adminlogin";
    }

    @GetMapping(value = "/category")
    public String loadCategory(){
    	return "category";
    	}

    @GetMapping(value = "/product")
    public String loadProduct(ModelMap model){
        List<Category> categoryList= cs.showCategory();
        model.addAttribute("catList",categoryList);
        return "product";
    }
    
    @GetMapping(value = "/Products")
    public String getAllProduct(ModelMap model){
        List<Product> productList= ps.getAllProducts();
        model.addAttribute("prodList",productList);
        return "AllProduct";
    }

    @PostMapping(value = "addProduct")
    @ResponseBody
    public String addProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        String result = null;
        String prodName=request.getParameter("pName");
        String prodCat=request.getParameter("pCat");
        int prodCount=Integer.parseInt(request.getParameter("pCount"));
        int prodPrice=Integer.parseInt(request.getParameter("pPrice"));
        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
           if( bytes != null){
               String fname=file.getOriginalFilename();
               String path = currentDirectory+"//pictures//"+fname;
               File obj = new File(path);
               if(obj.createNewFile()){
                   FileOutputStream fos = new FileOutputStream(path);
                   fos.write(bytes);
                   Product p= new Product(prodName,prodCount,prodPrice,path,prodCat);
                   result = ps.saveProduct(p);
               }



           }else{
               result="Len is 0";
           }

        } catch (Exception e) {
            e.printStackTrace();
        }

      return result;
    }

    @PostMapping(value = "addCategory")
    @ResponseBody
    public String addCategory(HttpServletRequest request){
        String category = request.getParameter("cname");
        String result=cs.saveCategory(category);
       return result;
    }

    @PostMapping(value = "/validateAdmin")
    public String validateAdmin(HttpServletRequest request){

        String user = request.getParameter("email");
        String pwd = request.getParameter("password");
        if(user.equalsIgnoreCase("abc@gmail.com")
            && pwd.equals("123")){
            return "adminHome";
        }else{
            return "adminFail";
        }
    }
}
