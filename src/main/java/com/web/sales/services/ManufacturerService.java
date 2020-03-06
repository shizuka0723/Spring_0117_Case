package com.web.sales.services;

import com.web.sales.dao.ManufacturerRepository;
import com.web.sales.models.Manufacturer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {
    
    @Autowired
    private ManufacturerRepository dao;
    
    public void add(Manufacturer entity){
        dao.save(entity);
    }
    
    public Manufacturer get(Integer id){
        return dao.findById(id).get();
    }
    
    public boolean exisit(Integer id){
        return dao.existsById(id);
    }
    
    public List<Manufacturer> query(){
        List<Manufacturer> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }
    
    public void update(Manufacturer entity){
        dao.update(entity);
    }
    
}
