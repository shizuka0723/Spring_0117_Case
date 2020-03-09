package com.web.sales.controller;

import com.web.sales.models.Customer;
import com.web.sales.services.CustomerService;
import com.web.sales.services.DiscountCodeService;
import com.web.sales.services.MicroMarketService;
import com.web.sales.services.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/")
    public String input(Model model) {
        model.addAttribute("list_customers", service.list_customers());
        model.addAttribute("list_products", service.list_products());
        return "report";
    }

    
}
