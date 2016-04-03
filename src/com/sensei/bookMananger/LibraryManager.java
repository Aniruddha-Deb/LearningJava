package com.sensei.bookMananger;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    
    private Library library = new Library() ;
    private Scanner scanner = new Scanner( System.in ) ;
    
    public void addBookToLibrary( Book book ) {
        library.addBook( book ) ;
    }
    
    public void listBooksInLibrary() {
        ArrayList<Book> books = library.getAllBooks() ;
        for( Book book : books ) {
            System.out.println( book ) ;
        }
    }
    
    public Book createNewBook() {
        
        Book book = null ;
        
        System.out.println( "Would you like to enter data for another book? [y/n] " );
        String choice = scanner.nextLine() ;
        
        if( choice.equals( "Y" ) || choice.equals( "y" ) ) {
            book = new Book() ;
            System.out.println( "Enter book name: " );
            book.setBookName( scanner.nextLine() ) ;
            System.out.println( "Enter book publisher: " );
            book.setPublisher( scanner.nextLine() ) ;
        }
        else {
           scanner.close() ; 
        }
        
        return book ;
    }
    
    public static void main( String[] args ) {
       
        LibraryManager manager = new LibraryManager() ;
        Book book = manager.createNewBook() ;
        while( book != null ) {
            manager.addBookToLibrary( book ) ;
            book = manager.createNewBook() ;
        }
        
        manager.listBooksInLibrary() ;
    }
}
