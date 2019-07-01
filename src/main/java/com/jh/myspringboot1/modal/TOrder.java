package com.jh.myspringboot1.modal;

import java.sql.Time;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class TOrder {
   private Integer orderId;
   private Integer userId;
   private String status;
   private Date createDateTime;

/*    public static void main(String[] args) {
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone); //此处打印为时区所在城市Asia/Shanghai
    }*/
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
