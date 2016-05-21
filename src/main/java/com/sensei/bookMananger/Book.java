package com.sensei.bookMananger;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable{

	private String bookName;
    private String author;
    private String genre;  
    private int    pages;
    private int    bookUID;
    
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
    
    public int getBookUID() {
        return bookUID;
    }
    
    public void setBookUID(int UID) {
    	this.bookUID = UID;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer() ;
        buffer.append( "UID    : " ).append( bookUID ).append( "\n" )
        	  .append( "Book   : " ).append( bookName ).append( "\n" )
              .append( "Author : " ).append( author ).append( "\n" )
              .append( "Genre  : " ).append( genre ).append( "\n" )
              .append( "Pages  : " ).append( pages ).append( "\n" );
        return buffer.toString() ;
    }
}
