package com.web.sales.controller;

import com.web.sales.models.PurchaseOrder;
import com.web.sales.services.CustomerService;
import com.web.sales.services.ProductService;
import com.web.sales.services.PurchaseOrderService;
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
@RequestMapping("/purchase_order")
public class PurchaseOrderController {
    
    @Autowired
    private PurchaseOrderService service;
    
    @Autowired
    private CustomerService service_c;
    
    @Autowired
    private ProductService service_p;
    
    @RequestMapping("/input")
    public String input(Model model) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        List<PurchaseOrder> list = service.query();
        model.addAttribute("purchaseOrder", purchaseOrder);
        model.addAttribute("list", list);
        model.addAttribute("list_c", service_c.query());
        model.addAttribute("list_p", service_p.query());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "purchase_order";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PurchaseOrder purchaseOrder) {
        service.add(purchaseOrder);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable Integer id, Model model) {
        if (service.exisit(id)) {
            PurchaseOrder purchaseOrder = service.get(id);
            List<PurchaseOrder> list = service.query();
            model.addAttribute("purchaseOrder", purchaseOrder);
            model.addAttribute("list", list);
            model.addAttribute("list_c", service_c.query());
            model.addAttribute("list_p", service_p.query());
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "purchase_order";
        }
        return "redirect:../input";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute PurchaseOrder purchaseOrder) {
        service.update(purchaseOrder);
        return "redirect:./input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        return "redirect:../input";
    }
}
