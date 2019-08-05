package com.example.pckosek.ui_example_02;

import com.google.gson.Gson;

public class MyUser {
    public String name;
    public int age;

    public MyUser(String n, int a) {
        name = n;
        age  = a;
    }

    public String toJson() {
        Gson gson = new Gson();
        return  gson.toJson(this, this.getClass());
    }
}
