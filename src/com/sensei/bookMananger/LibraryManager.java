package com.sensei.bookMananger;

import java.util.Scanner;

public class LibraryManager {
    
    public static Scanner scanner = new Scanner( System.in ) ;
    private Database database = null;
    private Library library = null;
    public static String choice;
    private int nextBookUID = 0;
    
    public LibraryManager() {
    	database = new Database();
    	library = new Library( database );
    	nextBookUID = 0;
    }
    
    public String getChoiceForUserRetry() {
        String buffer = scanner.nextLine() ;
        while( !buffer.matches( "[YyNn]" ) ) {
            System.out.print( "Do you want to enter another book: " );
            buffer = scanner.nextLine();
        }
        return buffer;
    }
    
    public Book createNewBook() {
        
        Book book = null ;
        
        book = new Book() ;
        System.out.print( "Enter book Name: " );
        book.setBookName( scanner.nextLine() ) ;
        System.out.print( "Enter book Author: " );
        book.setAuthor( scanner.nextLine() ) ;
        System.out.print( "Enter book Genre: " );
        book.setGenre( scanner.nextLine() );
        System.out.print( "Enter size of book (in pages): " );
        book.setPages( scanner.nextInt() );
        book.setBookUID( nextBookUID );
        nextBookUID++;
        
        return book ;
    }
    
    public void printStartMenu() {
        
        System.out.println( "LibraryManager INDEV");
        System.out.println( "================================================" );
        System.out.println( "What would you like to do:" );
        System.out.println( "    1) Display books in library" );
        System.out.println( "    2) Add new book to library" );
        System.out.println( "    3) Erase all books in library" );
        System.out.println( "    4) Exit LibraryManager" );
        System.out.println( "================================================" );
        System.out.print( "Wating on choice:> " );
        choice = scanner.nextLine();
    }
    
    public void manageLibrary() throws Exception {
    	
        Book book;
        String input = "Y";
        
        do {
            printStartMenu();
            if( choice.equals( "1" ) ) {
                library.list();
                System.out.println( "" );
            }
            else if( choice.equals( "2" )) {
                do {
                    book = createNewBook();
                    library.addBook( book );
                    input = getChoiceForUserRetry();
                } while( input.equals( "y" ) || input.equals( "Y" ) ); 
            }
            else if( choice.equals( "3" ) ) {
                System.out.println( "Are you sure you want to erase all books in your library?" );
                System.out.print( "Press y to continue, n to abort" );
                input = getChoiceForUserRetry();
                if( input.matches( "[Yy]" ) ) {
                    library.erase( nextBookUID );
                }
                else{
                    System.out.println( "Aborting..." );
                }
            }
            else if( choice.equals( "4" )) {
            	library.save( nextBookUID );
                scanner.close();
                System.exit( -1 );
            }
        } while ( true );
    }
    
    public static void main( String[] args ) throws Exception{
       
        LibraryManager manager = new LibraryManager() ;
        manager.manageLibrary();
    }
}
