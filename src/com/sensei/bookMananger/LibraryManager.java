package com.sensei.bookMananger;

import java.util.Scanner;
import java.io.*;

public class LibraryManager {
    
    public File library = new File( "/home/sensei/library.txt" );
    public static Scanner scanner = new Scanner( System.in ) ;
    public static String choice;
    
    public String getChoiceForUserRetry() {
        String buffer = scanner.nextLine() ;
        while( !buffer.matches( "[YyNn]" ) ) {
            System.out.println( "Do you want to enter another book: " );
            buffer = scanner.nextLine();
        }
        return buffer;
    }
    
    public void addBookToLibrary( Book book ) throws IOException{
        
        if( !library.exists() ) {
            library.createNewFile();
        }
        
        FileWriter writer = new FileWriter( library, true );
        char[] buffer = book.toString().toCharArray();
        writer.write( buffer );
        writer.write( "================================================\n" );
        writer.flush();
        writer.close(); 
    }
    
    public void eraseAllBooksInLibrary() throws IOException{
        
        FileWriter writer = new FileWriter( library );
        writer.write( "" );
        writer.flush();
        writer.close(); 
    }
    
    public void listBooksInLibrary() throws IOException{
        FileReader fr = new FileReader( library ); 
        char[] a = new char[1024];
        fr.read(a); 
        for(char c : a)
            System.out.print(c); 
        fr.close();
    }
    
    public Book createNewBook() {
        
        Book book = null ;
        
        book = new Book() ;
        System.out.println( "Enter book Name: " );
        book.setBookName( scanner.nextLine() ) ;
        System.out.println( "Enter book Author: " );
        book.setAuthor( scanner.nextLine() ) ;
        System.out.println( "Enter book Genre: " );
        book.setGenre( scanner.nextLine() );
        System.out.println( "Enter size of book (in pages): " );
        book.setPages( scanner.nextInt() );
        
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
        System.out.println( "Wating on choice:> " );
        choice = scanner.nextLine();
    }
    
    public static void main( String[] args ) throws Exception{
       
        LibraryManager manager = new LibraryManager() ;
        Book book;
        String input = "Y";
        
        do {
            manager.printStartMenu();
            if( choice.equals( "1" ) ) {
                manager.listBooksInLibrary();
                System.out.println( "========================================" );
                System.out.println( "" );
            }
            else if( choice.equals( "2" )) {
                do {
                    book = manager.createNewBook();
                    manager.addBookToLibrary( book );
                    input = manager.getChoiceForUserRetry();
                } while( input.equals( "y" ) || input.equals( "Y" ) ); 
            }
            else if( choice.equals( "3" ) ) {
                System.out.println( "Are you sure you want to erase all books in your library?" );
                System.out.println( "Press y to continue, n to abort" );
                input = manager.getChoiceForUserRetry();
                if( input.matches( "[Yy]" ) ) {
                    manager.eraseAllBooksInLibrary();
                }
                else{
                    System.out.println( "Aborting..." );
                }
            }
            else if( choice.equals( "4" )) {
                scanner.close();
                System.exit( -1 );
            }
        } while ( true );
    }
}
