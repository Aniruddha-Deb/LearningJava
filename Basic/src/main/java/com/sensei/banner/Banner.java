package com.sensei.banner;

import com.sensei.banner.characters.*;

public class Banner {
    
    private Character[] characters = new Character[26] ;
    
    private void loadCharacters() {
        characters[0] = new CharacterA();
        characters[1] = new CharacterB();
        characters[2] = new CharacterC();
        characters[3] = new CharacterD();
        characters[4] = new CharacterE();
        characters[5] = new CharacterF();
        characters[6] = new CharacterG();
        characters[7] = new CharacterH();
        characters[8] = new CharacterI();
        characters[9] = new CharacterJ();
        characters[10] = new CharacterK();
        characters[11] = new CharacterL();
        characters[12] = new CharacterM();
        characters[13] = new CharacterN();
        characters[14] = new CharacterO();
        characters[15] = new CharacterP();
        characters[16] = new CharacterQ();
        characters[17] = new CharacterR();
        characters[18] = new CharacterS();
        characters[19] = new CharacterT();
        characters[20] = new CharacterU();
        characters[21] = new CharacterV();
        characters[22] = new CharacterW();
        characters[23] = new CharacterX();
        characters[24] = new CharacterY();
        characters[25] = new CharacterZ();
    }

    private void printVertical( String string, boolean italics ) {
        
        String text = string.toUpperCase() ;
        for( int i=0; i<text.length(); i++ ) {
            char      ch    = text.charAt(i) ;
            int       index = ch - 'A' ;
            Character c     = characters[index] ;
            Line      line  = new Line() ;
            
            line.appendToLine( c ) ;
            if( italics ) {
                line.printItalics() ;
            }
            else {
                line.print() ;
            }
            System.out.println() ;
        }
    }
    
    private void printHorizontal( String string, boolean italics ) {
        
        String text = string.toUpperCase() ;
        Line   line = new Line() ;
        for( int i=0; i<text.length(); i++ ) {
            char      ch    = text.charAt(i) ;
            int       index = ch - 'A' ;
            Character c     = characters[index] ;
            line.appendToLine( c ) ;
            line.appendSpaceToLine() ;
        }
        
        if( italics ) {
            line.printItalics() ;
        }
        else {
            line.print()  ;
        }
    }
    
    public static void main( String[] args ) {
        
        if( args.length < 1 ) {
            System.out.println( "Banner: no command line arguments passed" );
            System.out.println( "Type -help for help on banner" );
            System.exit( -1 );
        }
        
        Banner banner = new Banner() ;
        banner.loadCharacters() ;
   
        if( args[0].equals( "-h" ) ) {
            banner.printHorizontal( args[1], false );
        }
        else if( args[0].equals( "-hi" ) ) {
            banner.printHorizontal( args[1], true );
        }
        else if( args[0].equals( "-v" ) ) {
            banner.printVertical( args[1], false );
        }
        else if( args[0].equals( "-vi" ) ) {
            banner.printVertical( args[1], true );
        }
        else {
            System.out.println( "Banner: Incorrect command." );
            System.out.println( "Type -help for help on banner" );
        }
    }
}