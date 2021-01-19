package service;

import Dao.JDBCUtil;
import pojo.Information;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUD {
    Information information=new Information();


    //添加信息
    public boolean add(String name,String pwd,String phone){
        boolean result=false;
        JDBCUtil.getConnection();
        //如果受影响行数不为0则插入成功
        if (JDBCUtil.add(name,pwd,phone)!=0){result=true;}
        JDBCUtil.mysqlColse();
        return result;

    }

    //删除信息
    public boolean delete(String name,String pwd,String phone){
        boolean result=false;
        JDBCUtil.getConnection();
        //如果受影响行数不为0则删除成功
        if (JDBCUtil.deletein(name,phone)!=0){result=true;}
        JDBCUtil.mysqlColse();
        return result;
    }

    //遍历信息
    public LinkedList erodic(){
        JDBCUtil.getConnection();
        //information.list=null;
        ResultSet resultSet=JDBCUtil.ergioc();
        //返回结果不为空进行遍历
        if (resultSet!=null){
                try {
                    while(resultSet.next()) {
                        String name=resultSet.getString(1);
                        String pwd =resultSet.getString(2);
                        String phone=resultSet.getString(3);
                        information.list.add(new Information(name,pwd,phone));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }

        return information.list;
    }


}
