package com.example.pckosek.volley_06;

import java.io.Serializable;

public class MyPhotoUser implements Serializable{

    public String name;
    public String photoUrl;

    public MyPhotoUser(String n, String p) {
        name = n;
        photoUrl  = p;
    }
}
