package com.example.ResumeBuilderApp.Service.Impl;

import com.example.ResumeBuilderApp.Dao.UserDao;
import com.example.ResumeBuilderApp.Entity.User;
import com.example.ResumeBuilderApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {

        User userName=this.userDao.findByUserName(user.getUserName());
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        if(userName!=null)
        {
            return null;
        }
        this.userDao.save(user);
        return user;
    }
}
