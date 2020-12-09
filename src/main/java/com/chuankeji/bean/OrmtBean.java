package com.chuankeji.bean;

public class OrmtBean {

    private String name;
    private int age;

    public OrmtBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public OrmtBean() {

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
