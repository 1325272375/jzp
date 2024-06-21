package com.one.entity;

public class StudentBean {

    private String id;
    private String pwd;
    private String xm;
    private String sex;


    private String phone;

    @Override
    public String toString() {
        return "TeacherBean{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", xm='" + xm + '\'' +
                ", sex='" + sex + '\'' +
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

    public StudentBean() {
    }

    public StudentBean(String id, String pwd, String xm, String sex, String phone, String adress) {
        this.id = id;
        this.pwd = pwd;
        this.xm = xm;
        this.sex = sex;

        this.phone = phone;
        this.adress = adress;
    }

    private String adress;

    private String bj;

    public StudentBean(String id, String pwd, String xm, String sex, String phone, String adress, String bj) {
        this.id = id;
        this.pwd = pwd;
        this.xm = xm;
        this.sex = sex;
        this.phone = phone;
        this.adress = adress;
        this.bj = bj;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }
}
