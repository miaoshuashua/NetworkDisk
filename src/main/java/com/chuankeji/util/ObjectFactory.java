package com.chuankeji.util;

public class ObjectFactory {
    public static Object newInstance(String className){
        Object obj = null;
        try {
            Class clazz = Class.forName(className);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
