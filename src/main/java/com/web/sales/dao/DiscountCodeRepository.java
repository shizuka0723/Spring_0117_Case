package com.web.sales.dao;

import com.web.sales.models.DiscountCode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountCodeRepository implements CrudRepository<DiscountCode, String>{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(DiscountCode entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DiscountCode> findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<DiscountCode> findAll() {
        String sql = "SELECT * FROM DISCOUNT_CODE";
        List<DiscountCode> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DiscountCode entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
