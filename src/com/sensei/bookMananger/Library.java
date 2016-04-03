package com.sensei.bookMananger;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>() ;
    
    public Library(){
    }
    
    public void addBook( Book book ) {
        books.add( book ) ;
    }
    
    public ArrayList<Book> getAllBooks() {
        return books ;
    }
}
