package com.example.SecurityDemo.Controller;

import com.example.SecurityDemo.Model.student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String  HomePage(HttpServletRequest request){
        return "Hello World "+request.getSession().getId();}

   List<student> students=new ArrayList<>(){{
       add(new student("vihang",21,82));
       add(new student("kalpak",22,72));
       add(new student("aditya",23,92));
   }};
    @GetMapping("/students")
    public List<student> studentInfo() {


        return students;
    }};

