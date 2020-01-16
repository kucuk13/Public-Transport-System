package com.example.project;

public class Person {
    static String id;
    static String name;
    static String email;
    static String password;
    static String tel;

    public Person(){
        id = "";
        name = "";
        email = "";
        password = "";
        tel = "";
    }

    public Person(String id, String name, String email, String password, String tel){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

}
