package com.example.demo.Exceptions;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException (String message){
        System.out.println(message);
    }
}
