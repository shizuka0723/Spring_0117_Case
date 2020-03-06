package com.web.sales.services;

import com.web.sales.dao.ProductCodeRepository;
import com.web.sales.models.ProductCode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductCodeService {
    
    @Autowired
    private ProductCodeRepository dao;
    
    public void add(ProductCode entity){
        dao.save(entity);
    }
    
    public ProductCode get(String id){
        return dao.findById(id).get();
    }
    
    public boolean exisit(String id){
        return dao.existsById(id);
    }
    
    public List<ProductCode> query(){
        List<ProductCode> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }
    
    public void delete(String id){
        dao.deleteById(id);
    }
    
    public void update(ProductCode entity){
        dao.update(entity);
    }
    
}
