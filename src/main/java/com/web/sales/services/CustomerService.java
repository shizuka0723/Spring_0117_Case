package com.web.sales.services;

import com.web.sales.dao.CustomerRepository;
import com.web.sales.models.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository dao;
    
    public void add(Customer entity){
        dao.save(entity);
    }
    
    public Customer get(Integer id){
        return dao.findById(id).get();
    }
    
    public boolean exist(Integer id){
        return dao.existsById(id);
    }
    
    public List<Customer> query(){
        List<Customer> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }
    
    public void update(Customer entity){
        dao.update(entity);
    }
    
}
