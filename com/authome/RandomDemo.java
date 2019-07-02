package com.authome;

import java.util.Random;

import py4j.GatewayServer;

public class RandomDemo {
    public static void main(String[] args) {
        Random a= new Random();
        System.out.println(a.nextInt(10));


    }


    public int addition(int first,int second){
        return  first +second;
    }


}
