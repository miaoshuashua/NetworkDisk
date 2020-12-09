package com.chuankeji.util;

import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    //mybatis-config.xml配置文件路径
    public static final String CONFIG_PATH="mybatis-config.xml";
    //SqlSessionFactory工程对象
    private SqlSessionFactory sessionFactory = null;
    private SqlSession session = null;
    private static  MyBatisUtil instance = null;

    private MyBatisUtil() {
        Reader reader = null;

            //首先获取这个mybatis-config.xml配置文件,实现数据库的连接
        try {
            reader = Resources.getResourceAsReader(CONFIG_PATH);
            //获取配置文件中需要执行的方法和实体类
            sessionFactory =  new SqlSessionFactoryBuilder().build(reader);
            //开启事务回滚
            session = sessionFactory.openSession(false);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //获取MyBatisUtil单例
    public static synchronized  MyBatisUtil getInstance()  {
        if(null == instance){
            synchronized(MyBatisUtil.class){
                instance = new MyBatisUtil();
            }
        }
        return  instance;
    }

    public synchronized SqlSession getSqlSession(){
        return session;
    }
}
