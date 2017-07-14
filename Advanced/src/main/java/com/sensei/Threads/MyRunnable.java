package com.sensei.Threads;

public class MyRunnable implements Runnable{

	private int start = 0 ;
	private int end = 0 ;
	
	public MyRunnable( int from, int to ) {
		this.start = from ;
		this.end = to ;
	}
	
	public void run() {
		for( int i=start; i<=end; i++ ) {
			System.out.println( i );
			try {
				Thread.sleep((int)(10000*Math.random())) ;
			}
			catch( Exception e ) {
				// Eat and ignore.
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		MyRunnable r1 = new MyRunnable( 1, 10 ) ;
		MyRunnable r2 = new MyRunnable( 11, 20 ) ;
		
		Thread t1 = new Thread( r1 );
		Thread t2 = new Thread( r2 );
		
		t1.start();
		t2.start();
		
		t1.join() ;
		t2.join() ;
	}
}
