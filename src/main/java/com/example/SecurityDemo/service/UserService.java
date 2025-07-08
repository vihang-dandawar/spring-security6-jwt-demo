package com.example.SecurityDemo.service;

import com.example.SecurityDemo.Model.User;
import com.example.SecurityDemo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
            JWTService jwtService;
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User Register(User user)
    {
       user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);

    }

    public String verify(User user){
        Authentication Authentication=authManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
         if(Authentication.isAuthenticated())
         {
             return  jwtService.getTokens(user.getUsername());
         }
         else
    return " Not Authenticated!!";
    }
}
