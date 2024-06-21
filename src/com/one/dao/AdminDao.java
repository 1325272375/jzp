package com.one.dao;

import com.one.entity.ClsBean;
import com.one.entity.StudentBean;
import com.one.entity.TeacherBean;
import com.one.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public  static Connection con= DBUtil.con; // 声明Connection对象

    /**
     * 通过账号，密码，权限，进行登录功能
     * @param account
     * @param password
     * @param pow
     * @return
     */
    public int Login(String account,String password,String pow){

        if(pow.equals("1")){
            String sql="select * from s_admin where s_user=? and s_pwd=?";
            ResultSet rs = DBUtil.queryRs(sql, account, password);
            try{
                while(rs.next()){
                    return 1;
                }
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }

        }else if(pow.equals("2")){
            String sql="select * from d_teacher where id=? and pwd=?";
            ResultSet rs = DBUtil.queryRs(sql, account, password);
            try{
                while(rs.next()){

                    String zc=rs.getString("zc");
                    if(zc.equals("导员")){
                        return 11;
                    }else{
                        return 22;
                    }

                }
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else{



            String sql="select * from d_student where id=? and pwd=?";
            ResultSet rs = DBUtil.queryRs(sql, account, password);
            try {
                while(rs.next()){
                    return 1;
                }
            }catch (Exception e){
                return -1;
            }





        }



        return 0;
    }


    /**
     * 查询所有老师的内容
     * @return
     */
    public List<TeacherBean> findAllTeacher(){
        String sql="select * from d_teacher";
        ResultSet rs = DBUtil.queryRs(sql);
        List<TeacherBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                TeacherBean teacherBean=new TeacherBean(rs.getString(1),
                                                        rs.getString(2),
                                                        rs.getString(3),
                                                        rs.getString(4),
                                                        rs.getString(5),
                                                        rs.getString(6),
                                                        rs.getString(7));
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 根据ID查询老师
     * @return
     */
    public List<TeacherBean> findAllTeacher(String id){
        String sql="select * from d_teacher where id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        List<TeacherBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                TeacherBean teacherBean=new TeacherBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    /**
     *实现删除老师的功能
     * @param id
     * @return
     */
    public int  removeTeacherById(String id){
        String sql="DELETE FROM d_teacher where id=?";
        return DBUtil.update(sql,id);
    }

    public int  removeStuById(String id){
        String sql="DELETE FROM d_student where id=?";
        return DBUtil.update(sql,id);
    }
    public int  removeClsById(String id){

        String sql="DELETE FROM d_cls where id=?";
        return DBUtil.update(sql,id);
    }
    public int  addTeacher(String ...data){

        String sql="INSERT into d_teacher (id,xm,sex,zc,phone,adress) VALUES(?,?,?,?,?,?)";
        return DBUtil.update(sql,data);

    }

    public int  addStu(String ...data){

        String sql="INSERT into d_student (id,xm,sex,phone,adress,bj) VALUES(?,?,?,?,?,?)";
        return DBUtil.update(sql,data);

    }

    public int   updateTeacher(String ...data){
        String sql="update  d_teacher set id=?,xm=?,sex=?,zc=?,phone=?,adress=? where id=?";
        return DBUtil.update(sql,data);
    }

    public int   updateTeacher(String pwd,String phone,String address,String id){
        String sql="update  d_teacher set pwd=?,phone=?,adress=? where id=?";
        String da[]={pwd,phone,address,id};
        return DBUtil.update(sql,da);
    }

    public int   updateStu(String ...data){
        String sql="update  d_student set id=?,xm=?,sex=?,phone=?,adress=?,bj=? where id=?";
        return DBUtil.update(sql,data);
    }

    public int   updateStu( String pwd,String phone,String address,String id){
        String sql="update  d_student set pwd=?,phone=?,adress=? where id=?";
        String data[]={pwd,phone,address,id};
        return DBUtil.update(sql,data);
    }


    public int   addCls(String ...data){
        String sql="insert into  d_cls values(?,?,?,?)";
        return DBUtil.update(sql,data);
    }

    public int   updateCls(String ...data){
        String sql="UPDATE d_cls set id=?,bname=?,pro=?,s_id=? where id=?";
        return DBUtil.update(sql,data);
    }









    /**
     * 查询所有老师的内容
     * @return
     */
    public List<ClsBean> findAllCls(){
        String sql="select * from d_cls";
        ResultSet rs = DBUtil.queryRs(sql);
        List<ClsBean> list =new ArrayList<>();

        try{
            while(rs.next()){



                ClsBean teacherBean=new ClsBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



    /**
     * 查询所有老师的内容
     * @return
     */
    public List<ClsBean>  findAllClsByS_id(String id){
        String sql="select * from d_cls where s_id=?";
        String da[]={id};
        ResultSet rs = DBUtil.queryRs(sql,da);
        List<ClsBean> list =new ArrayList<>();

        try{
            while(rs.next()){



                ClsBean teacherBean=new ClsBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    /**
     * 根据ID查询老师
     * @return
     */
    public List<ClsBean> findAllCls(String id){

        String sql="select * from d_cls where id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        List<ClsBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                ClsBean teacherBean=new ClsBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }


    /**
     * 查询所有老师的内容
     * @return
     */
    public List<StudentBean> findAllStu(){
        String sql="select * from d_student";
        ResultSet rs = DBUtil.queryRs(sql);
        List<StudentBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                StudentBean teacherBean=new StudentBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                      );
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 根据ID查询老师
     * @return
     */
    public List<StudentBean> findAllStu(String id){
        String sql="select * from d_student where id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
            List<StudentBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                StudentBean teacherBean=new StudentBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public List<StudentBean> findAllStuByBj(String id){
        String sql="select * from d_student where bj=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        List<StudentBean> list =new ArrayList<>();

        try{
            while(rs.next()){
                StudentBean teacherBean=new StudentBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                list.add(teacherBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }





}
