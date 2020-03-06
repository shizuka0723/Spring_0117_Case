package com.web.sales.dao;

import com.web.sales.models.ProductCode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCodeRepository implements CrudRepository<ProductCode, String>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(ProductCode entity) {
        String sql = "INSERT INTO PRODUCT_CODE(PROD_CODE,DISCOUNT_CODE,DESCRIPTION) VALUES(?,?,?)";
        jdbcTemplate.update(sql,entity.getProdCode(),entity.getDiscountCode(),entity.getDescription());
    }

    @Override
    public Optional<ProductCode> findById(String id) {
        String sql = "SELECT * FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        ProductCode pc = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
        return Optional.of(pc);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<ProductCode> findAll() {
        String sql = "SELECT * FROM PRODUCT_CODE";
        List<ProductCode> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM PRODUCT_CODE WHERE PROD_CODE = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(ProductCode entity) {
        String sql = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?,DESCRIPTION = ? WHERE PROD_CODE = ?";
        jdbcTemplate.update(sql, entity.getDiscountCode(),entity.getDescription(),entity.getProdCode());
    }
    
    
}
