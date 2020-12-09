package com.chuankeji.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;

public class MappingUtils {
    public static Element fetchXml(){
        File file = new File("src/main/resources/TestInfo.xml");
        //实例化xml解析器
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(file);
            Element root = doc.getRootElement();
            return  root;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

//    插入方法
    public static String fetchInsertSql(String ben){
        try {
            Class clz = Class.forName(ben);
            String clzStr = clz.toString();
            //获取类名
            String beanName = clzStr.substring(clzStr.lastIndexOf(".")+1).toLowerCase();
            //获取类中所有的属性
            Field[] fileds = clz.getDeclaredFields();
            StringBuffer sb = null;
            String fileName = "";
            for(Field filed:fileds){
                fileName +=","+filed.getName();
                if(sb==null){
                    sb = new StringBuffer();
                    sb.append("?");
                }else{
                    sb.append(" , ?");
                }
            }
            return "insert into" +beanName+"("+fileName.substring(1)+") values (" +sb.toString() +")";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
