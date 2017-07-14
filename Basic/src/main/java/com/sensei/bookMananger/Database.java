package com.sensei.bookMananger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
	
	private File file = null;

	public Database() {
		String homePath = System.getProperty( "user.home" ) ;
		file = new File( homePath, "library.ds" ) ;
	}
	
	@SuppressWarnings("unchecked")
	public void load( Library library ) {
		
		int UID = 0;
		ArrayList<Book> books = null ;
		
		if( file.exists() ) {
			try {
				FileInputStream   fis = new FileInputStream( file ) ;
				ObjectInputStream ois = new ObjectInputStream( fis ) ;
				
				books = ( ArrayList<Book> )ois.readObject() ;
				UID = ois.readInt();
				ois.close();
			}
			catch( Exception e ){
				e.printStackTrace( );
			}
		}
		else {
			books = new ArrayList<Book>() ;
		}
		library.setBooks( books );
		library.setNextBookUID( UID );
	}
	
	public void save( Library library ) {

		ArrayList<Book> books = null ;
		
		try {
			FileOutputStream   fos = new FileOutputStream( file ) ;
			ObjectOutputStream oos = new ObjectOutputStream( fos ) ;
			
			books = library.getAllBooks();
			oos.writeObject( books ) ;
			oos.writeInt( library.getNextBookUID() );
			oos.close();
		}
		catch( Exception e ){
			e.printStackTrace( );
		}
	}
}
