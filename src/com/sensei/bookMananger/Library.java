package com.sensei.bookMananger;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>() ;
    private Database database = null;
    
    public Library( Database database ){
    	this.database = database;
    	load();
    }
    
    public void addBook( Book book ) {
        books.add( book ) ;
    }
    
    public ArrayList<Book> getAllBooks() {
        return books ;
    }
    
    public void load() {
    	
    }
    
    public void save() {
    	
    }

	public void erase() {
	}

	public void list() {
	}
}
