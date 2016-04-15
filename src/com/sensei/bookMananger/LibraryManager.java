package com.sensei.bookMananger;

import java.util.Scanner;

public class LibraryManager {
    
    public static Scanner scanner = new Scanner( System.in ) ;
    private Database database = null;
    private Library library = null;
    public static String choice;
    
    public LibraryManager() {
    	database = new Database();
    	library = new Library( database );
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
        
        return book ;
    }
    
    public void printStartMenu() {
        
        System.out.println( "LibraryManager INDEV");
        System.out.println( "================================================" );
        System.out.println( "What would you like to do:" );
        System.out.println( "    1) Display books in library" );
        System.out.println( "    2) Add new book to library" );
        System.out.println( "    3) Delete a book from the library" );
        System.out.println( "    4) Erase all books in library" );
        System.out.println( "    5) Exit LibraryManager" );
        System.out.println( "================================================" );
        System.out.print( "Wating on choice:> " );
        choice = scanner.nextLine();
    }
    
    public void displayBooksInLibrary() {
    	library.list();
    	System.out.println( "" );
    }
    
    public void addNewBookToLibrary() {
    	Book book;
    	String input = "Y";
        do {
            book = createNewBook();
            library.addBook( book );
            input = getChoiceForUserRetry();
        } while( input.equals( "y" ) || input.equals( "Y" ) ); 
    }
    
    private void deleteBookFromLibrary() {
    	int UID;
    	System.out.print( "Enter the UID of the book you want to delete: " );
    	UID = scanner.nextInt();
    	library.deleteBook( UID );
    	library.save();
    }
    
    public void eraseAllBooksInLibrary() {
    	
    	String input = "Y";
    	
        System.out.println( "Are you sure you want to erase all books in your library?" );
        System.out.print( "Press y to continue, n to abort: " );
        input = getChoiceForUserRetry();
        if( input.matches( "[Yy]" ) ) {
        	library.erase();
        }
        else{
            System.out.println( "Aborting..." );
        }
    }
    
    public void exitLibraryManager() {
        scanner.close();
        library.save();
        System.exit( -1 );
    }
    
    public void manageLibrary() throws Exception {
    	
        do {
            printStartMenu();
            if( choice.equals( "1" ) ) {
            	displayBooksInLibrary();
            }
            else if( choice.equals( "2" )) {
            	addNewBookToLibrary();
            }
            else if( choice.equals( "3" )) {
            	deleteBookFromLibrary();
            }
            else if( choice.equals( "4" ) ) {
            	eraseAllBooksInLibrary();
            }
            else if( choice.equals( "5" )) {
            	exitLibraryManager();
            }
        } while ( true );
    }
    
	public static void main( String[] args ) throws Exception{
       
        LibraryManager manager = new LibraryManager() ;
        manager.manageLibrary();
    }
}
