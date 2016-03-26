package com.sensei.banner;

public class Character {
    
    public static final int BITMAP_R = 7 ;
    public static final int BITMAP_C = 7 ;
    
    private char bitmap[][] = new char[BITMAP_R][BITMAP_C] ;
    
    public void print() {
        for( int r=0; r<BITMAP_R; r++ ) {
            for( int c=0; c<BITMAP_C; c++ ) {
                System.out.print( bitmap[r][c] ) ;
            }
            System.out.println() ;
        }
    }
    
    public char[][] getBitmap() {
        return bitmap ;
    }
    
    protected void initializeBitmap( String l0, String l1, String l2, 
                                     String l3, String l4, String l5, 
                                     String l6 ) {
        importIntoBitmap( 0, l0 ) ;
        importIntoBitmap( 1, l1 ) ;
        importIntoBitmap( 2, l2 ) ;
        importIntoBitmap( 3, l3 ) ;
        importIntoBitmap( 4, l4 ) ;
        importIntoBitmap( 5, l5 ) ;
        importIntoBitmap( 6, l6 ) ;
    }
    
    private void importIntoBitmap( int index, String content ) {
        
        char[] bitmapRow = bitmap[index] ;
        for( int i=0; i<BITMAP_C; i++ ) {
            char ch = ' ' ;
            if( i < content.length() ) {
                ch = content.charAt( i ) ;
            }
            bitmapRow[i] = ch ;
        }
    }
}
