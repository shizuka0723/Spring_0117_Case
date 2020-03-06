package com.web.sales.dao;

import com.web.sales.models.PurchaseOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderRepository implements CrudRepository<PurchaseOrder, Integer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(PurchaseOrder entity) {
        String sql = "INSERT INTO PURCHASE_ORDER(ORDER_NUM,CUSTOMER_ID,PRODUCT_ID,QUANTITY,SHIPPING_COST,SALES_DATE,SHIPPING_DATE,FREIGHT_COMPANY) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, entity.getOrderNum(), entity.getCustomerId(), entity.getProductId(), entity.getQuantity(), entity.getShippingCost(), entity.getSalesDate(), entity.getShippingDate(), entity.getFreightCompany());
    }

    @Override
    public Optional<PurchaseOrder> findById(Integer id) {
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        PurchaseOrder purchaseOrder = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return Optional.of(purchaseOrder);
    }

    @Override
    public boolean existsById(Integer id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<PurchaseOrder> findAll() {
        String sql = "SELECT * FROM PURCHASE_ORDER";
        List<PurchaseOrder> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(PurchaseOrder entity) {
        String sql = "UPDATE PURCHASE_ORDER SET CUSTOMER_ID = ?,PRODUCT_ID = ?,QUANTITY=?,SHIPPING_COST=?,SALES_DATE=?,SHIPPING_DATE=?,FREIGHT_COMPANY=? WHERE ORDER_NUM = ?";
        jdbcTemplate.update(sql, entity.getCustomerId(), entity.getProductId(), entity.getQuantity(), entity.getShippingCost(), entity.getSalesDate(), entity.getShippingDate(), entity.getFreightCompany(),entity.getOrderNum());
    }
}
