package com.sensei.banner;

public class Line {

    private StringBuffer lines[] = new StringBuffer[ Character.BITMAP_R ];

    public Line() {
        for( int i=0; i<Character.BITMAP_R; i++ ) {
            lines[i] = new StringBuffer() ;
        }
    }
    
    public void clear() {
        for( int i=0; i<Character.BITMAP_R; i++ ) {
            lines[i] = new StringBuffer() ;
        }
    }
    
    public void print() {
        for( int i=0; i<Character.BITMAP_R; i++ ) {
            System.out.println( lines[i] ) ;
        }
    }
    
    public void printItalics() {
        for( int i=0, space = 6; i<Character.BITMAP_R; i++, space--) {
            for( int j=space; j>=0; j-- ) {
                System.out.print( " " );
            }
            System.out.println( lines[i] ) ;
        }
    }

    public void appendToLine( Character ch ) {
        char[][] bitmap = ch.getBitmap() ;
        for( int row=0; row<Character.BITMAP_R; row++ ) {
            for( int col=0; col<Character.BITMAP_C; col++ ) {
                lines[row].append( bitmap[row][col] ) ;
            }
        }
    }
    
    public void appendSpaceToLine() {
        for( int row=0; row<Character.BITMAP_R; row++ ) {
            lines[row].append( "  " ) ;
        }
    }
}
