package com.web.sales.service;

import com.web.sales.dao.DiscountCodeRepository;
import com.web.sales.models.DiscountCode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCodeService {
    
    @Autowired
    private DiscountCodeRepository dao;
    
    public List<DiscountCode> query(){
        List<DiscountCode> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }
}
