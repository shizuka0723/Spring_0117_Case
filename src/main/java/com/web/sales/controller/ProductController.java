package com.web.sales.controller;

import com.web.sales.models.Product;
import com.web.sales.services.ManufacturerService;
import com.web.sales.services.ProductCodeService;
import com.web.sales.services.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    @Autowired
    private ManufacturerService service_mf;
    
    @Autowired
    private ProductCodeService service_pc;
    
    @RequestMapping("/input")
    public String input(Model model) {
        Product product = new Product();
        List<Product> list = service.query();
        model.addAttribute("product", product);
        model.addAttribute("list", list);
        model.addAttribute("list_mf", service_mf.query());
        model.addAttribute("list_pc", service_pc.query());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "product";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        service.add(product);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable Integer id, Model model) {
        if (service.exisit(id)) {
            Product product = service.get(id);
            List<Product> list = service.query();
            model.addAttribute("product", product);
            model.addAttribute("list", list);
            model.addAttribute("list_mf", service_mf.query());
            model.addAttribute("list_pc", service_pc.query());
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "product";
        }
        return "redirect:../input";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        service.update(product);
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        return "redirect:../input";
    }
}
