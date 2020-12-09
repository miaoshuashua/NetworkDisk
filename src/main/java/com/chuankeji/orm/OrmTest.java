package com.chuankeji.orm;

import com.chuankeji.bean.OrmtBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OrmTest {
    public static void main(String[] args) throws NoSuchFieldException {
        //运行当中构任意一个类的对象
//        try {
//            //使用Class静态类的方法
//            Class myclass = Class.forName("com.chuankeji.bean.OrmtBean");
//            //使用类的.class语法
//            Class myclass1 = OrmtBean.class;
//            //使用对象点getClass()；
//            OrmtBean orm = new OrmtBean();
//            orm.getClass();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        //在运行中构造一个任意的对象
        Class<OrmtBean> ormtBeanClass = OrmtBean.class;
        //1.方法一
        try {
            //这种方法实现的是类的无参构造，无法传递参数
            OrmtBean ormtBean=ormtBeanClass.newInstance();
            Field name = ormtBeanClass.getDeclaredField("name");
            name.setAccessible(true);//打开暴力访问的开关


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //2.方法二 通过Constructor对象，来获取类对象
        try {
            //这种方法通过通过类加载文件去执行.getConstructor(String.class,int.class)，传递对应的构造函数的参数来实现有参数的初始化
            Constructor<OrmtBean> cons = ormtBeanClass.getConstructor(String.class,int.class);
            //上面指定传递对应参数的class类型那么他声明实例化对应的构造函数就是对应的参数，实例化有梨花
            OrmtBean orm = cons.newInstance("peter",10);
            System.out.println(orm.getName()+"==="+orm.getAge());
            System.out.println(ormtBeanClass.getMethod("getName").invoke(orm)+"===="+ormtBeanClass.getMethod("getAge").invoke(orm));
            Method[] methods = ormtBeanClass.getDeclaredMethods();
            for(Method method:methods){
                System.out.println(method.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
