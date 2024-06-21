package com.one.service.impl;

import com.one.dao.AdminDao;
import com.one.dao.TeacherDao;
import com.one.entity.*;
import com.one.service.LoginService;
import com.one.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherDao teacherDao=new TeacherDao();

    public List<CourseBean> findAllCourse(String tid){

        return teacherDao. findAllCourse(tid);

    }
    public List<CourseBean> findAllCourse(){

        return teacherDao. findAllCourse();

    }
    public List<CourseBean> findAllCourse(String id,String tid){

        return teacherDao. findAllCourse(id,tid);

    }

    public int  removeCourseById(String id){
        return teacherDao.removeCourseById(id);
    }

    //更改课程
    public  int updateCourse(String ...data){
        return teacherDao.updateCourse(data);
    }
    public  int addCourse(String ...data){
        return teacherDao.addCourse(data);
    }

    public List<SoreBean> findAllSore(String id){
        return teacherDao.findAllSore(id);
    }

    public  int updateSoreS(String ...data){
        return teacherDao.updateSoreS(data);
    }

    public int isSelect(String stuid,String cid){
        return teacherDao.isSelect(stuid,cid);
    }
    public int selectCourse(String stuid,String cid){
        return teacherDao.selectCourse(stuid,cid);
    }
    public int noSelectCourse(String stuid,String cid){
        return teacherDao.noSelectCourse(stuid,cid);
    }

    public List<StudentSoreBean> getSore(String ...id){
        return teacherDao. getSore(id);
    }
}
