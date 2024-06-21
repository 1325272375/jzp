package com.one.entity;

public class TeacherBean {

    private String id;
    private String pwd;
    private String xm;
    private String sex;
    private String zc;

    private String phone;

    @Override
    public String toString() {
        return "TeacherBean{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", xm='" + xm + '\'' +
                ", sex='" + sex + '\'' +
                ", zc='" + zc + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public TeacherBean() {
    }

    public TeacherBean(String id, String pwd, String xm, String sex, String zc, String phone, String adress) {
        this.id = id;
        this.pwd = pwd;
        this.xm = xm;
        this.sex = sex;
        this.zc = zc;
        this.phone = phone;
        this.adress = adress;
    }

    private String adress;


}
