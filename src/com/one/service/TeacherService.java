package com.one.service;

import com.one.entity.CourseBean;
import com.one.entity.SoreBean;
import com.one.entity.StudentSoreBean;

import java.util.List;

public interface TeacherService {


    public List<CourseBean> findAllCourse(String id);
    public List<CourseBean> findAllCourse();
    public List<CourseBean> findAllCourse(String id,String tid);
    public int  removeCourseById(String id);
    public  int updateCourse(String ...data);

    public  int addCourse(String ...data);

    public List<SoreBean> findAllSore(String id);

    public  int updateSoreS(String ...data);


    public int isSelect(String stuid,String cid);

    //选课
    public int selectCourse(String stuid,String cid);

    public int noSelectCourse(String stuid,String cid);

    public List<StudentSoreBean> getSore(String ...id);
}
