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
	public ArrayList<Book> load() {
		
		ArrayList<Book> books = null ;
		
		if( file.exists() ) {
			try {
				FileInputStream   fis = new FileInputStream( file ) ;
				ObjectInputStream ois = new ObjectInputStream( fis ) ;
				
				books = ( ArrayList<Book> )ois.readObject() ;
				ois.close();
			}
			catch( Exception e ){
				e.printStackTrace( );
			}
		}
		else {
			books = new ArrayList<>() ;
		}
		return books ;
	}

	public void save(ArrayList<Book> books, int UID) {

		try {
			FileOutputStream   fos = new FileOutputStream( file ) ;
			ObjectOutputStream oos = new ObjectOutputStream( fos ) ;
			
			oos.writeObject( books ) ;
			oos.writeInt( UID );
			oos.close();
		}
		catch( Exception e ){
			e.printStackTrace( );
		}
	}
}
