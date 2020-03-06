package com.web.sales.controller;

import com.web.sales.models.Customer;
import com.web.sales.services.CustomerService;
import com.web.sales.services.DiscountCodeService;
import com.web.sales.services.MicroMarketService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private DiscountCodeService service_dc;

    @Autowired
    private MicroMarketService service_mm;

    @GetMapping("/input")
    public String input(Model model) {
        Customer customer = new Customer();
        List<Customer> list = service.query();
        model.addAttribute("customer", customer);
        model.addAttribute("list", list);
        model.addAttribute("list_dc", service_dc.query());
        model.addAttribute("list_mm", service_mm.query());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "customer";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer) {
        service.add(customer);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        if (service.exist(id)) {
            Customer customer = service.get(id);
            List<Customer> list = service.query();
            model.addAttribute("customer", customer);
            model.addAttribute("list", list);
            model.addAttribute("list_dc", service_dc.query());
            model.addAttribute("list_mm", service_mm.query());
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "customer";
        }
        return "redirect:./input";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        service.update(customer);
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String update(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:../input";
    }
}
