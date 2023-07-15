package com.eb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students") //http://localhost:8080/SpringMVC/students
public class StudentController
{
    @GetMapping("/hi") //http://localhost:8080/SpringMVC/students/hi
    public ModelAndView sayHi()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello");
        mav.addObject("messagebody", "I'm a student management system!");
        mav.setViewName("hi");  //hi.jsp


        return mav;
    }
}
