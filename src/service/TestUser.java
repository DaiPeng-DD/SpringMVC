package service;

import Dao.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUser {

    public Boolean testUser(String acc,String pwd) throws Exception {
        boolean result=false;


        //连接数据库
        JDBCUtil.getConnection();
        ResultSet resultSet=JDBCUtil.getTestUserStatement(acc,pwd);
        try {
            if (resultSet.next()){//throw new Exception("cuowu ");
                result=true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //关闭数据库
        JDBCUtil.mysqlColse();
        return result;
    }
}
