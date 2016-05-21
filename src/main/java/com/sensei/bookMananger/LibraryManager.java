package com.sensei.bookMananger;

public class LibraryManager {
    
    private String choice;
    private Database database = null;
    private Library library = null;
    private ConsoleReader scanner = null ;
    
    public LibraryManager() {
    	database = new Database();
    	library = new Library( database );
    	scanner = new ConsoleReader() ;
    }
    
    public Book createNewBook() {
        
        Book book = null ;
        
        book = new Book() ;
        book.setBookName( scanner.getString( "Enter book Name: " ) ) ;
        book.setAuthor( scanner.getString( "Enter book Author: " ) ) ;
        book.setGenre( scanner.getString( "Enter book Genre: " ) );
        book.setPages( scanner.getInt( "Enter size of book (in pages): " ) );
        
        return book ;
    }

    public void printStartMenu() {
        
        System.out.println( "LibraryManager INDEV");
        System.out.println( "================================================" );
        System.out.println( "What would you like to do:" );
        System.out.println( "    1) Display books in library" );
        System.out.println( "    2) Search a particular book from the library" );
        System.out.println( "    3) Add new book to library" );
        System.out.println( "    4) Delete a book from the library" );
        System.out.println( "    5) Erase all books in library" );
        System.out.println( "    6) Exit LibraryManager" );
        System.out.println( "================================================" );
        choice = scanner.getString( "Wating on choice:> " );
    }
    
    public void printGenericMenu( String message ) {
    	System.out.println( message );
    	System.out.println( "    1) By Name" );
    	System.out.println( "    2) By Author" );
    	System.out.println( "    3) By Genre" );
    	System.out.println( "    4) By Size" );
    	System.out.println( "    5) Exit to main menu" );
    	System.out.println( "=============================" );
    	choice = scanner.getString( "Waiting on choice:> " );
    }

    public void displayBooksInLibrary() {
    	library.list();
    	System.out.println( "" );
    }
    
    public void searchBookInLibrary() {
    	
    	boolean doWhile = true;
    	String input;
    	int in;
    	
    	do {
	    	printGenericMenu( "How would you like to search for books? ");
	    	if( choice.equals( "1" ) ) {
	    		input = scanner.getString( "Enter the name of the book" );
	    		library.searchBookByName( input, false );
	    	}
	    	
	    	else if( choice.equals( "2" ) ){ 
	    		input = scanner.getString( "Enter the name of the Author" );
	    		library.searchBookByAuthor( input, false );
	    	}
	    	
	    	else if( choice.equals( "3" ) ){ 
	    		input = scanner.getString( "Enter the Genre to which the book belongs" );
	    		library.searchBookByGenre( input, false );
	    	}
	    	
	       	else if( choice.equals( "4" ) ){ 
	    		in = scanner.getInt( "Enter the number of pages" );
	       		library.searchBookByNumPages( in, false );
	       	}
	       	
	       	else if( choice.equals( "5" ) ){
	       		doWhile = false; 
	       		System.out.println( "" );
	       	}
	    	
    	} while( doWhile );
    }
    
    public void addNewBookToLibrary() {
    	Book book;
    	boolean loopCondition = true;
        do {
            book = createNewBook();
            library.addBook( book );
            loopCondition = scanner.getUserConfirmation( "Do you want to enter another book?" ); 
        } while( loopCondition == true ); 
    }
    
    private void deleteBookFromLibrary() {
    	boolean doWhile = true;
    	String input;
    	int in;
    	
    	do {
	    	printGenericMenu( "How would you like to delete books? ");
	    	if( choice.equals( "1" ) ) {
	    		input = scanner.getString( "Enter the name of the book" );
	    		library.searchBookByName( input, true );
	    	}
	    	
	    	else if( choice.equals( "2" ) ){ 
	    		input = scanner.getString( "Enter the name of the Author" );
	    		library.searchBookByAuthor( input, true );
	    	}
	    	
	    	else if( choice.equals( "3" ) ){ 
	    		input = scanner.getString( "Enter the Genre to which the book belongs" );
	    		library.searchBookByGenre( input, true );
	    	}
	    	
	       	else if( choice.equals( "4" ) ){ 
	    		in = scanner.getInt( "Enter the number of pages" );
	       		library.searchBookByNumPages( in, true );
	       	}
	       	
	       	else if( choice.equals( "5" ) ){
	       		doWhile = false; 
	       		System.out.println( "" );
	       	}
	    	
    	} while( doWhile );
    	
    	library.save();
    }
    
    public void eraseAllBooksInLibrary() {
    	
        if( scanner.getUserConfirmation("Are you sure you want to erase all books in your library?") ) {
        	library.erase();
        }
        else{
            System.out.println( "Aborting..." );
        }
    }
    
    public void exitLibraryManager() {
        library.save();
        System.exit( -1 );
    }
    
    public void manageLibrary() throws Exception {
    	
        do {
            printStartMenu();
            if( choice.equals( "1" ) ) 
            	displayBooksInLibrary();

            else if( choice.equals( "2" )) 
            	searchBookInLibrary();

            else if( choice.equals( "3" )) 
            	addNewBookToLibrary();

            else if( choice.equals( "4" )) 
            	deleteBookFromLibrary();

            else if( choice.equals( "5" ) ) 
            	eraseAllBooksInLibrary();

            else if( choice.equals( "6" )) 
            	exitLibraryManager();
            
        } while ( true );
    }
    
	public static void main( String[] args ) throws Exception{
       
        LibraryManager manager = new LibraryManager() ;
        manager.manageLibrary();
    }
}
