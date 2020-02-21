package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/micro_market")
public class MicroMarketController {
    
    @RequestMapping("/input")
    public String input(){
        return "micro_market";
    }
}
