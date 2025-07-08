package com.example.SecurityDemo.Controller;

import com.example.SecurityDemo.Model.User;
import com.example.SecurityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User Register(@RequestBody User user)
    {
        User saveduser=userService.Register(user);
        return saveduser;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user)
    {
         return userService.verify(user);
    }
}
