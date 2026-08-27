package com.jt.intro_to_web;

public class Person {
    private String name1;
    private String phone;
    public String getname1() {
        return name1;
    }
    public void setname1(String name1) {
        this.name1 = name1;
        System.out.println("name1 setter");
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("Phone setter");
    }
    
    
}
