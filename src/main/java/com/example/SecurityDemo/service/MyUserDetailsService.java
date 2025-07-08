package com.example.SecurityDemo.service;

import com.example.SecurityDemo.Model.User;
import com.example.SecurityDemo.Model.UserPrincipals;
import com.example.SecurityDemo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Looking for user: " + username);

        User user = userRepo.findByUsername(username); // ensure it's correct method name

        if (user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("User found: " + user.getUsername() + ", password: " + user.getPassword());
        return new UserPrincipals(user);
    }

}
