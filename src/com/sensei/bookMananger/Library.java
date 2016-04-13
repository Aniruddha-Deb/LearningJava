package com.sensei.bookMananger;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = null;
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
    	books = database.load();
    }
    
    public void save( int UID ) {
    	database.save( books, UID );
    }

	public void erase( int UID ) {
		books.clear();
		database.save( books, UID );
	}
	
	public void list() {
		for( Book book: books ) {
			System.out.println( book );
		}
	}
}
