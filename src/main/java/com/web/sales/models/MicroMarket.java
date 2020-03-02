package com.web.sales.models;


public class MicroMarket {
    
    private String zipCode;
    private Double radius;
    private Double areaLength;
    private Double areaWidth;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

    @Override
    public String toString() {
        return "MicroMarket{" + "zipCode=" + zipCode + ", radius=" + radius + ", areaLength=" + areaLength + ", areaWidth=" + areaWidth + '}';
    }
    
    
   
    
}