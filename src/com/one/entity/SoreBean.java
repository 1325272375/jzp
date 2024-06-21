package com.one.entity;

public class SoreBean {

    private String id;// 学号

    private String name;//姓名

    private String sorenum;//分数

    private String cid;//课程ID

    private String sid;//老师ID

    @Override
    public String toString() {
        return "SoreBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sorenum='" + sorenum + '\'' +
                ", cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }

    public SoreBean(String id, String name, String sorenum, String cid, String sid) {
        this.id = id;
        this.name = name;
        this.sorenum = sorenum;
        this.cid = cid;
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSorenum() {
        return sorenum;
    }

    public void setSorenum(String sorenum) {
        this.sorenum = sorenum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
