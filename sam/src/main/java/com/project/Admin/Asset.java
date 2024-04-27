package com.project.Admin;

public class Asset {
    private int no;
    private String name;
    private int quantity;
    private String employeeName;
    private String companyName;
    private String categoryName;
    private String license;

    public Asset(int no,String name, int quantity, String employee, String company, String category, String license){
        this.no=no;
        this.quantity=quantity;
        this.name=name;
        this.employeeName=employee;
        this.companyName=company;
        this.categoryName=category;
        this.license=license;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }


}
