package com.one.dao;

import com.one.entity.*;
import com.one.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public  static Connection con= DBUtil.con; // 声明Connection对象

    public List<CourseBean> findAllCourse(String tid){

        String sql="select *,  (select count(*) from d_cou_stu where course_id=d_course.id) from d_course where t_id=?";
        ResultSet rs = DBUtil.queryRs(sql,tid);
        List<CourseBean> list=new ArrayList<>();
        try {
            while (rs.next()){
                CourseBean courseBean=new CourseBean(rs.getString(1),
                                                     rs.getString(2),
                                                      rs.getString(3),
                                                        rs.getString(4),
                                                            rs.getString(5),
                                                          rs.getString(6),
                        rs.getString(7)

                        )  ;
                list.add(courseBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }
    public List<CourseBean> findAllCourse(){

        String sql="select *,  (select count(*) from d_cou_stu where course_id=d_course.id) from d_course";
        ResultSet rs = DBUtil.queryRs(sql);
        List<CourseBean> list=new ArrayList<>();
        try {
            while (rs.next()){
                CourseBean courseBean=new CourseBean(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)

                )  ;
                list.add(courseBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }


    public List<CourseBean> findAllCourse(String id,String tid){

        String sql="select *,  (select count(*) from d_cou_stu where course_id=d_course.id) " +
                " from d_course  where d_course.id=? and t_id=?";
        ResultSet rs = DBUtil.queryRs(sql,id,tid);
        List<CourseBean> list=new ArrayList<>();
        try {
            while (rs.next()){
                CourseBean courseBean=new CourseBean(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                )  ;
                list.add(courseBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }


    public int  removeCourseById(String id){
        String sql="DELETE FROM  d_course where id=?";
        return DBUtil.update(sql,id);
    }
    public  int updateCourse(String ...data){
        String sql="update d_course set id=?,cname=?,pos=?,ctime=?,peonum=? where id=?";
       return DBUtil.update(sql,data);
    }

    public  int addCourse(String ...data){
        String sql="insert into  d_course VALUES(?,?,?,?,?,?)";
        return DBUtil.update(sql,data);
    }

    public List<SoreBean> findAllSore(String id){
        String sql="select * from d_sore where id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        List<SoreBean> list=new ArrayList<>();
        try {
            while (rs.next()){
                SoreBean courseBean=new SoreBean(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)

                )  ;
                list.add(courseBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }


    public List<SoreBean> findAllSoreByStuId(String id){
        String sql="select * from d_sore where stu_id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        List<SoreBean> list=new ArrayList<>();
        try {
            while (rs.next()){
                SoreBean courseBean=new SoreBean(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)

                )  ;
                list.add(courseBean);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }

    public  int updateSoreS(String ...data){
        String sql="update d_cou_stu set sore=? where stu_id=? and course_id=?";;
        return DBUtil.update(sql,data);
    }

    public int isSelect(String ...data){
        String sql="select * from d_cou_stu where stu_id=? and course_id=? ";
        ResultSet rs = DBUtil.queryRs(sql, data);
        try {
            while(rs.next()){
                return 1;
            }
        }catch (Exception e){
            return -1;
        }
            return 0;


    }

    public int selectCourse(String ...data){
        String sql="insert into d_cou_stu VALUES(?,?,?) ";
        String da[]={data[0],data[1],"0"};
        return  DBUtil.update(sql,da);
    }
    public int noSelectCourse(String ...data){
        String sql="delete from d_cou_stu where stu_id=? and course_id=?";
        return  DBUtil.update(sql,data);
    }

    public List<StudentSoreBean> getSore(String ...id){

        String sql="select d_cou_stu.course_id, d_course.cname, d_course.pos, d_course.ctime ,d_cou_stu.sore from d_cou_stu LEFT JOIN d_course on d_course.id=d_cou_stu.course_id where d_cou_stu.stu_id=?";
        ResultSet rs = DBUtil.queryRs(sql,id);
        try{
            List<StudentSoreBean> list=new ArrayList<>();
            while(rs.next()){
               StudentSoreBean studentSoreBean=new StudentSoreBean(rs.getString(1),
                                                                    rs.getString(2),
                                                                    rs.getString(3),
                       rs.getString(4),
                       rs.getString(5));

                list.add(studentSoreBean);
            }
            return list;
        }catch (Exception e){
            return null;
        }



    }


}
