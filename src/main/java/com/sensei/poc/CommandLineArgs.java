package com.sensei.poc;

public class CommandLineArgs {

    public static void main( String[] args ) {
        for( int i=0; i<args.length; i++ ) {
            System.out.println( "CL arg [" + i + "] = " + args[i] ) ;
        }
    }
}
