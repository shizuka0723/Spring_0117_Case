package com.web.sales.dao;

import com.web.sales.models.Manufacturer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerRepository implements CrudRepository<Manufacturer, Integer>{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Manufacturer entity) {
        String sql = "INSERT INTO MANUFACTURER(MANUFACTURER_ID,NAME,ADDRESSLINE1,ADDRESSLINE2,CITY,STATE,ZIP,PHONE,FAX,EMAIL,REP) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,entity.getManufacturerId(),entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getZip(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getRep());
    }

    @Override
    public Optional<Manufacturer> findById(Integer id) {
        String sql = "SELECT * FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        Manufacturer manufacturer = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));
        return Optional.of(manufacturer);
    }

    @Override
    public boolean existsById(Integer id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Manufacturer> findAll() {
        String sql = "SELECT * FROM MANUFACTURER";
        List<Manufacturer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Manufacturer>(Manufacturer.class));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM MANUFACTURER WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Manufacturer entity) {
        String sql = "UPDATE MANUFACTURER SET NAME = ?,ADDRESSLINE1 =?,ADDRESSLINE2 =?,CITY =?,STATE =?,ZIP =?,PHONE =?,FAX =?,EMAIL =?,REP =? WHERE MANUFACTURER_ID = ?";
        jdbcTemplate.update(sql, entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getZip(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getRep(),entity.getManufacturerId());
    }
    
    
}
