package com.web.sales.controller;

import com.web.sales.models.MicroMarket;
import com.web.sales.services.MicroMarketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/micro_market")
public class MicroMarketController {
    
    @Autowired
    private MicroMarketService service;
    
    @GetMapping("/input")
    public String input(Model model) {
        MicroMarket microMarket = new MicroMarket();
        List<MicroMarket> list = service.query();
        model.addAttribute("microMarket", microMarket);
        model.addAttribute("list", list);
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "micro_market";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute MicroMarket microMarket) {
        service.add(microMarket);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        if (service.exists(id)) {
            MicroMarket microMarket = service.get(id);
            List<MicroMarket> list = service.query();
            model.addAttribute("microMarket", microMarket);
            model.addAttribute("list", list);
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "micro_market";
        }
        return "redirect:./input";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute MicroMarket microMarket) {
        service.update(microMarket);
        return "redirect:./input";
    }
    
    @GetMapping("/delete/{id}")
    public String update(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:../input";
    }
    
}