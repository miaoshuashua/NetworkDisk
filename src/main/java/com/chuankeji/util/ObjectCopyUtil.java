package com.chuankeji.util;


import javax.xml.transform.Source;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//拷贝工具类
    public class ObjectCopyUtil {

        public static Object copyObj(Object obj) throws Exception {
            //创建一个新的对象
            Class<?> classType = obj.getClass();//获取class对象
            Object objRes = classType.newInstance();//构建目标对象
            //这边就是循环暴破解，获取每一个属性
            for (Field field : classType.getDeclaredFields()) {
                //获取属性名字
                String fieldName = field.getName();
                //根据set属性名获取get和set方法
                String set = "set" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                String get = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                //根据方法名称获取对象
                Method methodSet = classType.getMethod(set,field.getType());
                Method methodGet = classType.getMethod(get);
                //执行目标对象的get方法
                Object returnVal = methodGet.invoke(obj);
                //执行目标对象的set方法，将原对象的值赋值个目标对象
                methodSet.invoke(objRes,returnVal);
                //执行原对象中的get方法，获取返回值
//                field.setAccessible(true);//设置可访问权限
//                Object value = field.get(obj);//利用get方法取obj的值
//                field.set(objRes, value);
            }
            return objRes;
        }

}
