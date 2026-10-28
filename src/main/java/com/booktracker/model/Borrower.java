package com.booktracker.model;
public class Borrower {
    private int borrowerId; private String fullName,email,phone;
    public Borrower(int id,String name,String email,String phone){this.borrowerId=id;this.fullName=name;this.email=email;this.phone=phone;}
    public int getBorrowerId(){return borrowerId;} public String getFullName(){return fullName;} public String getEmail(){return email;} public String getPhone(){return phone;}
}
