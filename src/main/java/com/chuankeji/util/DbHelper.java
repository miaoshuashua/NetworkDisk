package com.chuankeji.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {

    //获取连接和连接的对象还有配置文件
    private ComboPooledDataSource dataSource;

    public static DbHelper dbHelper;
    private Connection connection;



    private  DbHelper(){

        dataSource = new ComboPooledDataSource("oracle");
    }



    public synchronized  static  DbHelper getDbHelper(){
        if(dbHelper==null){

            dbHelper = new DbHelper();
        }
        return dbHelper;
    }

    public  DataSource getdataSource(){
        return dataSource;
    }

    //获取连接
    public Connection getConnection(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  connection;
    }
    //返回连接池
    public void close(Connection connection){

        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
