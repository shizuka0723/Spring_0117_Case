package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @RequestMapping("/input")
    public String input(){
        return "customer";
    }
}
