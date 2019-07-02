package com.examples;

public class Student {

    private String name;
    private  int  age ;

    public Student(){};
    public Student(String name,int age) {
        this.name = name;
        this.age=age;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age) {
        this.age = age;
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



    public  void  show(){

        System.out.println("我是一个学生");

    }

    public  int  returnValue(){
        return 1;
    }
}
