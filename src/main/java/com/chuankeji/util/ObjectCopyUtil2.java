package com.chuankeji.util;


    import java.lang.reflect.Field;

    public class ObjectCopyUtil2 {
        public static Object copyObj(Object obj) throws Exception {
            Class<?> classType = obj.getClass();//获取class对象
            Object objRes = classType.newInstance();//构建目标对象
                                //获取属性
            for (Field field : classType.getDeclaredFields()) {
                //使用父类的方法将访问权限检查的能力取消
                field.setAccessible(true);//设置可访问权限

                Object value = field.get(obj);//利用get方法取obj的值
                field.set(objRes, value);
            }
            return objRes;
        }

}
