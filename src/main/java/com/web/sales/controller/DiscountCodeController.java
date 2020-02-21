package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @RequestMapping("/input")
    public String input(){
        return "discount_code";
    }
}
