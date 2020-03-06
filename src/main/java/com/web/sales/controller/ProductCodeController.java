package com.web.sales.controller;

import com.web.sales.models.DiscountCode;
import com.web.sales.models.ProductCode;
import com.web.sales.services.DiscountCodeService;
import com.web.sales.services.ProductCodeService;
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
@RequestMapping("/product_code")
public class ProductCodeController {

    @Autowired
    private ProductCodeService service;

    @Autowired
    private DiscountCodeService service_dc;

    @RequestMapping("/input")
    public String input(Model model) {
        ProductCode productCode = new ProductCode();
        List<ProductCode> list = service.query();
        model.addAttribute("productCode", productCode);
        model.addAttribute("list", list);
        model.addAttribute("list_dc", service_dc.query());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "product_code";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ProductCode productCode) {
        service.add(productCode);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id, Model model) {
        if (service.exisit(id)) {
            ProductCode productCode = service.get(id);
            List<ProductCode> list = service.query();
            model.addAttribute("productCode", productCode);
            model.addAttribute("list", list);
            model.addAttribute("list_dc", service_dc.query());
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "product_code";
        }
        return "redirect:../input";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ProductCode productCode) {
        service.update(productCode);
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:../input";
    }
}
