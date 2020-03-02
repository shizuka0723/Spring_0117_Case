package com.web.sales.models;


public class DiscountCode {
    
    private String discountCode;
    
    private Double rate;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getLabel() {
        return discountCode + " : " + rate;
    }
    
    
    
}