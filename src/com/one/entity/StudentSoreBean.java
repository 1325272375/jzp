package com.one.entity;

public class StudentSoreBean {

    private    String id;
    private String name;
    private String pos;
    private String time;

    private String sore;

    @Override
    public String toString() {
        return "StudentSoreBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pos='" + pos + '\'' +
                ", time='" + time + '\'' +
                ", sore='" + sore + '\'' +
                '}';
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSore() {
        return sore;
    }

    public void setSore(String sore) {
        this.sore = sore;
    }

    public StudentSoreBean(String id, String name, String pos, String time, String sore) {
        this.id = id;
        this.name = name;
        this.pos = pos;
        this.time = time;
        this.sore = sore;
    }
}
