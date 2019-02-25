package com.jh.entity;

public class OrderItem {

    private long iid;
    private int count;
    private float subtotal;
    private long oid;
    private long fid;

    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid=" + iid +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", oid=" + oid +
                ", fid=" + fid +
                '}';
    }
}
