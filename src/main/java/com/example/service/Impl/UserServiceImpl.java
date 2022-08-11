package com.example.service.Impl;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;
    @Override
    public String saveSignUpInfo(User u) {
        String emailId= u.getEmail();
        if(!ud.existsByEmail(emailId)){
        User user=  ud.saveAndFlush(u);
        System.out.println("User Stored in DB:"+user);
        if(user.getEmail() != null) {
            return "User Created";
        } else
            return "Failed to Create User";
        }else

        return "User Already exists for Email:"+u.getEmail()+" Please try to Login.";
    }
}
