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
        String sql = "INSERT INTO DISCOUNT_CODE(DISCOUNT_CODE,RATE) VALUES(?,?)";
        jdbcTemplate.update(sql,entity.getDiscountCode(),entity.getRate());
    }

    @Override
    public Optional<DiscountCode> findById(String id) {
        String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        DiscountCode dc = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return Optional.of(dc);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<DiscountCode> findAll() {
        String sql = "SELECT * FROM DISCOUNT_CODE";
        List<DiscountCode> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(DiscountCode entity) {
        String sql = "UPDATE DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
        jdbcTemplate.update(sql, entity.getRate(),entity.getDiscountCode());
    }
    
    
}
