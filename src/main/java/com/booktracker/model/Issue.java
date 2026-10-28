package com.booktracker.model;
public class Issue {
    private int issueId,bookId,borrowerId; private String bookTitle,borrowerName,issueDate,dueDate,returnDate,status;
    public Issue(int id,int bookId,int borrowerId,String bookTitle,String borrowerName,String issueDate,String dueDate,String returnDate,String status){this.issueId=id;this.bookId=bookId;this.borrowerId=borrowerId;this.bookTitle=bookTitle;this.borrowerName=borrowerName;this.issueDate=issueDate;this.dueDate=dueDate;this.returnDate=returnDate;this.status=status;}
    public int getIssueId(){return issueId;} public int getBookId(){return bookId;} public int getBorrowerId(){return borrowerId;} public String getBookTitle(){return bookTitle;} public String getBorrowerName(){return borrowerName;} public String getIssueDate(){return issueDate;} public String getDueDate(){return dueDate;} public String getReturnDate(){return returnDate;} public String getStatus(){return status;}
}
