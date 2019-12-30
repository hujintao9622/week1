package com.bawei.week1.widget;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 下午 6:48
 */
public class Myclaass {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Myclaass(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Myclaass{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
