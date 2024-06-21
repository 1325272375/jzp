package com.one.utils;

import java.sql.*;

public class DBUtil {

    public  static Connection con; // 声明Connection对象
    public static String user="root";//数据库登录名
    public static  String password="";//密码

    public static  String db_name="db_student";//数据库名字

    public DBUtil(){
        getConnection();
    }


    public Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        }

        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name+"?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", user, password);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();

            System.out.println("链接数据库失败");
            String temp=e.getMessage();
            System.out.println(temp);
            String[] arr1=temp.split(" ");
            if(arr1[0].equals("Unknown")) {
                System.out.println("请建立名字为："+arr1[2]+"数据库");
            }
            if(arr1[0].equals("Access")) {
                System.out.println("请检查数据库密码是否正确：数据库密码错误");
            }
            if(temp.contains("the server was 0 milliseconds ago")){
                System.out.println("请安装Mysql数据库");
            }

        }
        return con; // 按方法要求返回一个Connection对象
    }

    //开始写查询
    public static ResultSet queryRs(String sql,String ...data){
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            for(int i=0;i<data.length;i++){
                pre.setString(i+1,data[i]);
            }
            ResultSet result = pre.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int  update(String sql,String ...data){
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            for(int i=0;i<data.length;i++){
                pre.setString(i+1,data[i]);
            }
            return pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


}
