package com.web.sales.dao;

import com.web.sales.models.report.ReportCustomer;
import com.web.sales.models.report.ReportProduct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Iterable<ReportCustomer> findAllCustomers() {
        String sql = "SELECT * FROM Report_Customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ReportCustomer.class));
    }
    
    public Iterable<ReportProduct> findAllProducts() {
        String sql = "SELECT * FROM Report_Product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ReportProduct.class));
    }
}
