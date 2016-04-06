package com.sensei.bookMananger;

public class Book {

    private String bookName;
    private String author;
    private String genre;  
    private int    pages;
    
    public Book() {
    }
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer() ;
        buffer.append( "Book   : " ).append( bookName ).append( "\n" )
              .append( "Author : " ).append( author ).append( "\n" )
              .append( "Genre  : " ).append( genre ).append( "\n" )
              .append( "Pages  : " ).append( pages ).append( "\n" );
        return buffer.toString() ;
    }
}