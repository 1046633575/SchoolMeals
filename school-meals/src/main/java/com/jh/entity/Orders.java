package com.jh.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Orders {

    private long oid;
    private Timestamp ordertime;
    private float total;
    private Integer state;
    private long uid;
    private String address;
    private String phone;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", uid=" + uid +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
