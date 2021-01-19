package Dao;

import java.sql.*;

public class JDBCUtil {
    private static Connection con=null;
    private static PreparedStatement Pstatement=null;
    private static ResultSet resultSet=null;
    private static String url="jdbc:mysql://47.94.14.32:3306";
    private static String name="root";
    private static String pwd="123456";
    private static String sql=null;

    //建立连接
    public static void getConnection(){
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //获取con对象
            con= DriverManager.getConnection(url,name,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("连接成功");
    }


    //获取执行对象并验证用户
    public static ResultSet getTestUserStatement(String name,String pwd){
        sql="select * from spring.user where acc=? and pwd=?";
        try {
            Pstatement= con.prepareStatement(sql);
            Pstatement.setString(1,name);
            Pstatement.setString(2,pwd);


            //像数据库发请求获取解过
            resultSet=Pstatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }


    //加信息
    public static int add(String acc,String pwd,String phone){
        sql="insert into spring.information (acc,password,phone,isdelete) values (?,?,?,?)";
        int i=0;
        //sql="Select acc,pwd,phone from information where ";
        try {
            Pstatement=con.prepareStatement(sql);
            Pstatement.setString(1,acc);
            Pstatement.setString(2,pwd);
            Pstatement.setString(3,phone);
            Pstatement.setString(4,"0");

            i=Pstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    //删信息
    public static int deletein(String acc,String phone){
        int i=0;
        sql="update spring.information set isdelete='1' where acc=? and phone=?";

        try {
            Pstatement=con.prepareStatement(sql);
            Pstatement.setString(1,acc);
            Pstatement.setString(2,phone);

            i=Pstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    //遍历
    public static ResultSet ergioc(){
        sql="Select acc,password,phone from spring.information where isdelete=?";
        try {
            Pstatement=con.prepareStatement(sql);
            Pstatement.setString(1,"0");

            resultSet=Pstatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }


    public static boolean mysqlColse(){
        boolean result=false;
        try {
            con.close();
            Pstatement.close();
            resultSet.close();
            result=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}
