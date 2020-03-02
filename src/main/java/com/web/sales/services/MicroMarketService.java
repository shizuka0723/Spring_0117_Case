package com.web.sales.services;

import com.web.sales.dao.MicroMarketRepository;
import com.web.sales.models.DiscountCode;
import com.web.sales.models.MicroMarket;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroMarketService {

    @Autowired
    private MicroMarketRepository dao;

    public void add(MicroMarket entity) {
        dao.save(entity);
    }

    public MicroMarket get(String id) {
        return dao.findById(id).get();
    }

    public boolean exists(String id) {
        return dao.existsById(id);
    }

    public List<MicroMarket> query() {
        List<MicroMarket> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
        return list;
    }

    public void delete(String id) {
        dao.deleteById(id);
    }

    public void update(MicroMarket entity) {
        dao.update(entity);
    }

}