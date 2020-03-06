package com.web.sales.dao;

import com.web.sales.models.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CrudRepository<Customer, Integer>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(Customer entity) {
        String sql = "INSERT INTO CUSTOMER(CUSTOMER_ID,DISCOUNT_CODE,ZIP,NAME,ADDRESSLINE1,ADDRESSLINE2,CITY,STATE,PHONE,FAX,EMAIL,CREDIT_LIMIT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,entity.getCustomerId(),entity.getDiscountCode(),entity.getZip(),entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getCreditLimit());
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));
        return Optional.of(customer);
    }

    @Override
    public boolean existsById(Integer id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Customer> findAll() {
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Customer entity) {
        String sql = "UPDATE CUSTOMER SET DISCOUNT_CODE = ?,ZIP=?,NAME=?,ADDRESSLINE1=?,ADDRESSLINE2=?,CITY=?,STATE=?,PHONE=?,FAX=?,EMAIL=?,CREDIT_LIMIT=?WHERE CUSTOMER_ID = ?";
        jdbcTemplate.update(sql, entity.getDiscountCode(),entity.getZip(),entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getCreditLimit(),entity.getCustomerId());
    }
}
