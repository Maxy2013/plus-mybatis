package com.plus.mybatis.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArraySortData {

    public static void main(String[] args) throws Exception{
       /* //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "root");

        //创建preparedStatement
        String sql = "select * from book" +
                "";
        PreparedStatement ps = c.prepareStatement(sql);
        //执行sql语句
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String number = rs.getString(3);
            String author = rs.getString(4);
            System.out.println(id+","+name+","+number+","+author);
        }
        //关闭连接
        c.close();*/

      /* //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management","root","root");

        //创建preparedStatement
        String sql = "select * from book " + "";
        PreparedStatement ps = c.prepareStatement(sql);
        //执行sql语句
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String number = rs.getString(3);
            String author = rs.getString(4);
            String publish = rs.getString(9);
            System.out.println(id+","+name+","+number+","+author+","+publish);
        }
        //关闭连接
        c.close();*/

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management","root","root");
        //创建preparedStatement
//        String sql = "insert into book values ('d3ahhhb','红楼梦','ABD-234564785','曹雪芹','ABD-234564785-123','02','2000','59.8','中国人民出版社','01') " ;
//        PreparedStatement ps = c.prepareStatement(sql);
//        //执行sql语句
//        int update = ps.executeUpdate(sql);
//        System.out.println(update);

        String sql2 = "select * from book" + "";
        PreparedStatement ps = c.prepareStatement(sql2);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            String id = resultSet.getString(1 );
            String name = resultSet.getString(2);
            String number = resultSet.getString(3);
            String author = resultSet.getString(4);
            String publish = resultSet.getString(9);
            System.out.println(id + "," + name + ","  + number +"," + author + "," + publish);
        }
        //关闭连接
        c.close();
    }
}
