package com.substring.smartresult.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class pageController {

    public String index(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("username","johnDoe");




        System.out.println("home page");
        return "index";
    }


    @GetMapping("/login-page")
    public String loginPage(){
        return "login_page";
    }

}
