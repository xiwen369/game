package com.qiqiji.backstage.game.demo;

public class Demo9 {
    /**
     * static的理解
     * ①static修饰的成员（字段/方法），随着所在的类加载而加载
     * ②优先于对象的存在
     * ③static修饰的成员被该类型的所有对象所共享
     * ④直接使用类名访问static成员
     * */
    public static void main(String[] args) {
//      ①static修饰的成员（字段/方法），随着所在的类加载而加载
//      ②优先于对象的存在
        System.out.println(Person.totalNum);
//      调用自定义的构造方法的构造方法,利用构造器的重载实现
        new Person("徐伟",18);
        System.out.println(Person.totalNum);
//      ③static修饰的成员被该类型的所有对象所共享
//      ④直接使用类名访问static成员
        Person.distory();
        System.out.println(Person.totalNum);
    }
}

class Person {
    String name;
    int age;
    static int totalNum = 5;

    Person(String name, int age) {
        System.out.println("您创造了一个人类" + "姓名=" + name + ",年龄=" + age);
        totalNum++;
    }

    void die() {
        System.out.println("死亡");
        totalNum--;
    }

    static void distory(){
        System.out.println("人类毁灭");
        totalNum = 0;

    }

}