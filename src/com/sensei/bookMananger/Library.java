package com.sensei.bookMananger;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = null;
    private Database database = null;
    private int nextBookUID = 0;
    
    public Library( Database database ){
    	this.database = database;
    	database.load(this);
    }
    
    public void addBook( Book book ) {
        books.add( book ) ;
        book.setBookUID( nextBookUID );
        nextBookUID++;
    }
    
    public ArrayList<Book> getAllBooks() {
        return books ;
    }
    
    public void setBooks( ArrayList<Book> books ) {
    	this.books = books;
    }
    
    public void setNextBookUID( int UID ) {
    	this.nextBookUID = UID;
    }
    
    public void save() {
    	database.save( this );
    }

	public void erase() {
		books.clear();
		nextBookUID = 0;
		database.save( this );
	}
	
	public void list() {
		for( Book book: books ) {
			System.out.println( book );
		}
	}

	public int getNextBookUID() {
		return nextBookUID;
	}

	public void deleteBook( int UID ) {
		int index = 0;
		for( int i=0; i<books.size(); i++ ) {
			if( books.get(i).getBookUID() == UID ) {
				index = i;
				break;
			}
		}
		books.remove( index );
	}
}
