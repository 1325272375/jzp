package com.one.service.impl;

import com.one.dao.AdminDao;
import com.one.entity.ClsBean;
import com.one.entity.StudentBean;
import com.one.entity.TeacherBean;
import com.one.service.LoginService;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    AdminDao adminDao=new AdminDao();
    @Override
    public int Login(String account, String password,String pow) {
       return adminDao.Login(account,password,pow);

    }


    public List<TeacherBean> findAllTeacher(){
        return adminDao.findAllTeacher();
    }
    public List<TeacherBean> findAllTeacher(String id){
        return adminDao.findAllTeacher(id);
    }




    public List<StudentBean> findAllStu(){
        return adminDao.findAllStu();
    }
    public List<StudentBean> findAllStu(String id){
        return adminDao.findAllStu(id);
    }

    public List<StudentBean> findAllStuByBj(String id){
        return adminDao.findAllStuByBj(id);
    }




    /**
     * 实现删除老师
     * @param id
     * @return
     */
    public int  removeTeacherById(String id){
        return adminDao.removeTeacherById(id);
    }

    public int  removeStuById(String id){
        return adminDao.removeStuById(id);
    }

    /**
     * 实现删除老师
     * @param id
     * @return
     */
    public int  removeClsById(String id){
        return adminDao.removeClsById(id);
    }


    public int  addTeacher(String ...data){
        return adminDao.addTeacher(data);
    }

    public int  addStu(String ...data){
        return adminDao.addStu(data);
    }


    public int   updateTeacher(String ...data){
        return adminDao. updateTeacher(data);
    }

    public int   updateTeacher(String pwd,String phone,String address,String id){
        return adminDao. updateTeacher(pwd,phone,address,id);
    }


    public int   updateStu(String ...data){
        return adminDao. updateStu(data);
    }
    public int   updateStu(String pwd,String phone,String address,String id){
        return adminDao. updateStu(pwd,phone,address,id);
    }

    public int   addCls(String ...data){
        return adminDao. addCls(data);
    }

    public int   updateCls(String ...data){
        return adminDao. updateCls(data);
    }



    public List<ClsBean> findAllCls(){
        return adminDao.findAllCls();
    }

    public List<ClsBean> findAllClsByS_id(String id){
        return adminDao.findAllClsByS_id(id);
    }
    public List<ClsBean> findAllCls(String id){
        return adminDao.findAllCls(id);
    }

    public List<TeacherBean> getAllDyTeacher(){

        List<TeacherBean> list = findAllTeacher();
        List<TeacherBean> lists=new ArrayList<>();
        for (TeacherBean teacherBean : list) {
            if(teacherBean.getZc().equals("导员")){
                lists.add(teacherBean);
            }
        }

        return lists;

    }

}
