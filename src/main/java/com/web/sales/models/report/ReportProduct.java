package com.web.sales.models.report;

public class ReportProduct {
    
    private Integer productId;
    private String productName;
    private String productCodeName;
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    

    public String getProductCodeName() {
        return productCodeName;
    }

    public void setProductCodeName(String productCodeName) {
        this.productCodeName = productCodeName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}
