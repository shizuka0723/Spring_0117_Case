package com.web.sales.models;

import java.util.Date;

public class Menu {
    
    private int menuId;
    private String menuKey;
    private String menuPath;
    private String menuText;
    private Date menuTs;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public Date getMenuTs() {
        return menuTs;
    }

    public void setMenuTs(Date menuTs) {
        this.menuTs = menuTs;
    }

    @Override
    public String toString() {
        return "Menu{" + "menuId=" + menuId + ", menuKey=" + menuKey + ", menuPath=" + menuPath + ", menuText=" + menuText + ", menuTs=" + menuTs + '}';
    }
    
    
    
}