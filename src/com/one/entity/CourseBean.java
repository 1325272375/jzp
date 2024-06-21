package com.one.entity;

public class CourseBean {


    private String id;

    private String cname;

    private String pos;


    private String ctime;


    private String peonum;
    private String tid;



    @Override
    public String toString() {
        return "CourseBean{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                ", pos='" + pos + '\'' +
                ", ctime='" + ctime + '\'' +
                ", peonum='" + peonum + '\'' +
                ", tid='" + tid + '\'' +
                ", nowpeo='" + nowpeo + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getPeonum() {
        return peonum;
    }

    public void setPeonum(String peonum) {
        this.peonum = peonum;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNowpeo() {
        return nowpeo;
    }

    public void setNowpeo(String nowpeo) {
        this.nowpeo = nowpeo;
    }

    public CourseBean(String id, String cname, String pos, String ctime, String peonum, String tid, String nowpeo) {
        this.id = id;
        this.cname = cname;
        this.pos = pos;
        this.ctime = ctime;
        this.peonum = peonum;
        this.tid = tid;
        this.nowpeo = nowpeo;
    }

    public CourseBean(String id, String cname, String pos, String ctime, String peonum, String tid) {
        this.id = id;
        this.cname = cname;
        this.pos = pos;
        this.ctime = ctime;
        this.peonum = peonum;
        this.tid = tid;
    }

    public CourseBean() {
    }

    private String nowpeo;


}
