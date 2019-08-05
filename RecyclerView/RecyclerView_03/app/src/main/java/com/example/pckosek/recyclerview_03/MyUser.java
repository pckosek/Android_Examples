package com.example.pckosek.recyclerview_03;

import java.io.Serializable;

public class MyUser implements Serializable{

    public int age;
    public String name;

    public MyUser(int a, String n) {
        this.age = a;
        this.name = n;
    }
}
