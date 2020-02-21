package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mirco_market")
public class MircoMarketController {
    
    @RequestMapping("/input")
    public String input(){
        return "mirco_market";
    }
}
