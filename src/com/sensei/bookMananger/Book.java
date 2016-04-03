package com.sensei.bookMananger;

public class Book {

    private String bookName;
    private String publisher;
    private String subject;  
    private int    pages;
    private int    price;
    
    public Book() {
    }
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer() ;
        buffer.append( "Book      : " ).append( bookName ).append( "\n" )
              .append( "Publisher : " ).append( publisher ).append( "\n" ) ;
        return buffer.toString() ;
    }
}
