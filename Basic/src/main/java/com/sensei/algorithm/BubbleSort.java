package com.sensei.algorithm;

public class BubbleSort {
	
	private int name[] = { 2, 1, 10, 11, 3, 0 };
	
	public void sortArray() {
		
		int buffer;
		for( int i=name.length-1; i>=0; i-- ) {
			for( int j=0; j<i; j++ ) {
				if( name[j] > name[j+1] ) {
					
					buffer = name[j];
					name[j] = name[j+1];
					name[j+1] = buffer;
					printArray() ;
					try{ 
						Thread.sleep(500) ; 
					}
					catch( Exception e ){
					}
				}
			}
		}
	}
	
	public void printArray() {
		System.out.print( "[" );
		for( int i=0; i<name.length-1; i++) {
			System.out.print( name[i] + "," );
		}
		System.out.println( name[name.length-1] + "]" );
	}

	public static void main( String[] args ) {
		BubbleSort driver = new BubbleSort() ;
		
		System.out.println( "Array before sorting." ) ;
		driver.printArray() ;
		System.out.println() ;
		
		driver.sortArray() ;
		
		System.out.println( "\nArray after sorting." ) ;
		driver.printArray() ;
	}
}
