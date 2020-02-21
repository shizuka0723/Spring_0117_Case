package com.web.sales.listener;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationData implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map menus = new LinkedHashMap();
        menus.put("discount_code.jsp", new String[]{"/mvc/discount_code/input", "優惠碼"});
        menus.put("micro_market.jsp", new String[]{"/mvc/micro_market/input", "市場區域"});
        menus.put("customer.jsp", new String[]{"/mvc/customer/input", "客戶資料"});
        menus.put("manufacturer.jsp", new String[]{"/mvc/manufacturer/input", "製造商資料"});
        menus.put("product_code.jsp", new String[]{"/mvc/product_code/input", "商品分類"});
        menus.put("product.jsp", new String[]{"/mvc/product/input", "商品資料"});
        menus.put("purchase_order.jsp", new String[]{"/mvc/purchase_order/input", "採購訂單"});
        sce.getServletContext().setAttribute("menus", menus);
    }
    
}
