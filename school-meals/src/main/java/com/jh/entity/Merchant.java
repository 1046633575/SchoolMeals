package com.jh.entity;

public class Merchant {

    private long mid;
    private String mname;
    private String mimage;
    private long cid;

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mimage='" + mimage + '\'' +
                ", cid=" + cid +
                '}';
    }
}
