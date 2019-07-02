package com.examples;

import py4j.GatewayServer;



public class StackEntryPoint {



    private  Stack stack;

    public  StackEntryPoint(){
        stack=new Stack();
        stack.push("Intial item");
    }

    public Stack getStack(){
        return  stack;
    }


    public  Student  getStudentInstance(){
        return  new Student();
    }


    public static void main(String[] args) {
        //entrypoint 是一个已经被创建的对象，所以python调用的是已经创建好的对象，即在堆中是存在的，可以直接调用其方法；

        GatewayServer gatewayServer=new GatewayServer(new StackEntryPoint());
        gatewayServer.start();
        String cp=System.getenv("CLASSPATH");
        System.out.println("classpath:"+cp);
        System.out.println("Gateway Server Started");
    }




}
