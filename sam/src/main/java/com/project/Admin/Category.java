package com.project.Admin;

public class Category {
    private int no;
    private String name;
    private String description;

    public Category(int no,String name, String desciription){
        this.no=no;
        this.name=name;
        this.description=desciription;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
