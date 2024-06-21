package com.one.entity;

public class ClsBean {

    private String id;
    private String bname;

    private String pro;

    private String s_id;

    @Override
    public String toString() {
        return "ClsBean{" +
                "id='" + id + '\'' +
                ", bname='" + bname + '\'' +
                ", pro='" + pro + '\'' +
                ", s_id='" + s_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public ClsBean() {
    }

    public ClsBean(String id, String bname, String pro, String s_id) {
        this.id = id;
        this.bname = bname;
        this.pro = pro;
        this.s_id = s_id;
    }
}
