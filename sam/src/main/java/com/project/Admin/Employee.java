package com.project.Admin;

public class Employee {

    private int no;
    private String name;
    private String address;
    private String city;
    private String email;
    private int contact;

    public Employee(int no, String name, String address, String city,
                   String email,int contact){
        this.no=no;
        this.name=name;
        this.address=address;
        this.city=city;
        this.email=email;
        this.contact=contact;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
