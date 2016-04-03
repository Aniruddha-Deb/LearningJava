package com.sensei.bookMananger;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    
    private Library library = new Library() ;
    private Scanner scanner = new Scanner( System.in ) ;
    public static String choice;

    public String getChoiceForUserRetry() {
        String buffer;
        System.out.println( "Do you want to enter another book: " );
        buffer = scanner.nextLine();
        return buffer;
    }
    
    
    public void addBookToLibrary( Book book ) {
        library.addBook( book ) ;
    }
    
    public void listBooksInLibrary() {
        ArrayList<Book> books = library.getAllBooks() ;
        for( Book book : books ) {
            System.out.println( book ) ;
            System.out.println( "------------------------------------" );
        }
    }
    
    public Book createNewBook() {
        
        Book book = null ;
        
        book = new Book() ;
        System.out.println( "Enter book name: " );
        book.setBookName( scanner.nextLine() ) ;
        System.out.println( "Enter book publisher: " );
        book.setPublisher( scanner.nextLine() ) ;
        
        return book ;
    }
    
    public void printStartMenu() {
        
        System.out.println( "LibraryManager INDEV");
        System.out.println( "================================================" );
        System.out.println( "What would you like to do:" );
        System.out.println( "    1) Display books in library" );
        System.out.println( "    2) Add new book to library" );
        System.out.println( "    3) Exit LibraryManager" );
        System.out.println( "================================================" );
        System.out.println( "Wating on choice:> " );
        choice = scanner.nextLine();
    }
    
    public static void main( String[] args ) {
       
        LibraryManager manager = new LibraryManager() ;
        Book book;
        
        do {
            manager.printStartMenu();
            if( choice.equals( "1" ) ) {
                manager.listBooksInLibrary();
                System.out.println( "========================================" );
                System.out.println( "" );
            }
            else if( choice.equals( "2" )) {
                String input;
                do {
                    book = manager.createNewBook();
                    manager.addBookToLibrary( book );
                    input = manager.getChoiceForUserRetry();
                } while( input.equals( "y" ) || input.equals( "Y" ) ); 
            }
            else if( choice.equals( "3" ) ) {
                new Scanner( System.in ).close();
                System.exit( -1 );
            }
        } while ( true );
    }
}
