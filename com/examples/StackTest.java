package com.examples;

import java.util.LinkedList;
import java.util.List;

public class StackTest {
    public static void main(String[] args) {

        List<String>   list=new LinkedList<String>();

        list.add("ab1");
        list.add("ab2");
        list.add("ab3");
        list.add("ab4");


        String  aa=list.remove(0);

        System.out.println(aa);



        Stack s=new Stack();
        s.push("2");

    }
}
