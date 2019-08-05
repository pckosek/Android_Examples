package com.example.pckosek.gsoninfragment;

public class AllUsers {

    public DummyUser[] user_list;
    private int indx = 0;


    public String getNextName() {
        indx++;
        indx %= user_list.length;

        return user_list[indx].name;
    }

    public class DummyUser {
        public int age;
        public String name;
    }

}
