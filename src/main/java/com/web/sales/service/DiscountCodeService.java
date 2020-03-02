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
    
    public void add(DiscountCode entity){
        dao.save(entity);
    }
    
    public DiscountCode get(String id){
        return dao.findById(id).get();
    }
    
    public boolean exisit(String id){
        return dao.existsById(id);
    }
    
    public List<DiscountCode> query(){
        List<DiscountCode> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }
    
    public void delete(String id){
        dao.deleteById(id);
    }
    
    public void update(DiscountCode entity){
        dao.update(entity);
    }
}
