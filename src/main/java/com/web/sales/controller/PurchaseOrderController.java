package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrderController {
    
    @RequestMapping("/input")
    public String input(){
        return "purchase_order";
    }
}
