package com.example.ResumeBuilderApp.Util;

import com.example.ResumeBuilderApp.Dao.UserDao;
import com.example.ResumeBuilderApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByUserName(username);
//        if(user==null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return (UserDetails) user;
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
    }
}
