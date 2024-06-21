package com.one.service;

import com.one.entity.ClsBean;
import com.one.entity.StudentBean;
import com.one.entity.TeacherBean;

import java.util.List;

public interface LoginService {


    public int Login(String account,String password,String pow);


    public List<TeacherBean> findAllTeacher();
    public List<TeacherBean> findAllTeacher(String id);

    public List<StudentBean> findAllStu();
    public List<StudentBean> findAllStu(String id);

    public List<StudentBean> findAllStuByBj(String id);
    public int  removeTeacherById(String id);

    public int  removeStuById(String id);
    public int  removeClsById(String id);
    public int   addTeacher(String ...data);
    public int  addStu(String ...data);
    public int   updateTeacher(String ...data);
    public int   updateTeacher(String pwd,String phone,String address,String id);
    public int   updateStu(String ...data);
    public int   updateStu(String pwd,String phone,String address,String id);
    public int   addCls(String ...data);
    public int   updateCls(String ...data);
    public List<ClsBean> findAllCls();
    public List<ClsBean> findAllCls(String id);
    public List<ClsBean> findAllClsByS_id(String id);
    /**
     * 获取所有导员
     * @return
     */
    public List<TeacherBean> getAllDyTeacher();



}
