package com.web.sales.dao;

import com.web.sales.models.DiscountCode;
import com.web.sales.models.MicroMarket;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MicroMarketRepository implements CrudRepository<MicroMarket, String>{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(MicroMarket entity) {
       String sql = "INSERT INTO MICRO_MARKET(ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getZipCode(), entity.getRadius(), entity.getAreaLength(), entity.getAreaWidth());
    }

    @Override
    public Optional<MicroMarket> findById(String id) {
        String sql = "SELECT * FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        MicroMarket mm = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
        return Optional.of(mm);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<MicroMarket> findAll() {
        String sql = "SELECT * FROM MICRO_MARKET";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM MICRO_MARKET WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(MicroMarket entity) {
        String sql = "UPDATE MICRO_MARKET SET RADIUS=?, AREA_LENGTH=?, AREA_WIDTH=? WHERE ZIP_CODE = ?";
        jdbcTemplate.update(sql, entity.getRadius(), entity.getAreaLength(), entity.getAreaWidth(), entity.getZipCode());
    }
    
}