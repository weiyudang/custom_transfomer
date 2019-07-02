package com.examples;

import java.util.LinkedList;
import java.util.List;

public class Stack {


    private List<String>  internalList=new LinkedList<String>();

    public  String name;


    public void  push(String element){
        this.internalList.add(element);
    }

    public  String pop(){
        return  this.internalList.remove(0);


    }

    public  void  pushAll(List<String> elements){
        for(String ele:elements){
            this.internalList.add(ele);
        }
    }


    public List  getInternalList(){
        return  this.internalList;
    }
}
