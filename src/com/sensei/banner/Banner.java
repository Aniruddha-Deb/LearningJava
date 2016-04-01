package com.sensei.banner;

import java.util.Scanner;

import com.sensei.banner.characters.CharacterA;
import com.sensei.banner.characters.CharacterB;
import com.sensei.banner.characters.CharacterC;
import com.sensei.banner.characters.CharacterD;
import com.sensei.banner.characters.CharacterE;
import com.sensei.banner.characters.CharacterF;
import com.sensei.banner.characters.CharacterG;
import com.sensei.banner.characters.CharacterH;
import com.sensei.banner.characters.CharacterI;
import com.sensei.banner.characters.CharacterJ;
import com.sensei.banner.characters.CharacterK;
import com.sensei.banner.characters.CharacterL;
import com.sensei.banner.characters.CharacterM;
import com.sensei.banner.characters.CharacterN;
import com.sensei.banner.characters.CharacterO;
import com.sensei.banner.characters.CharacterP;
import com.sensei.banner.characters.CharacterQ;
import com.sensei.banner.characters.CharacterR;
import com.sensei.banner.characters.CharacterS;
import com.sensei.banner.characters.CharacterT;
import com.sensei.banner.characters.CharacterU;
import com.sensei.banner.characters.CharacterV;
import com.sensei.banner.characters.CharacterW;
import com.sensei.banner.characters.CharacterX;
import com.sensei.banner.characters.CharacterY;
import com.sensei.banner.characters.CharacterZ;

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
        
        Scanner read = new Scanner(System.in);
        
        Banner banner = new Banner() ;
        banner.loadCharacters() ;
        
        System.out.println( "Enter banner text: " );
        String bannerString = read.nextLine();
        System.out.println( "Enter direction of banner text: " );
        String direction = read.nextLine();
        
        if( direction.equals( "H" ) ) {
            banner.printHorizontal( bannerString, false );
        }
        else if( direction.equals( "HI" ) ) {
            banner.printHorizontal( bannerString, true );
        }
        else if( direction.equals( "V" ) ) {
            banner.printVertical( bannerString, false );
        }
        else if( direction.equals( "VI" ) ) {
            banner.printVertical( bannerString, true );
        }
        else {
            System.out.println( "Direction can be either 'V' or 'VI' or 'H' or 'HI'.");
        }
        
        read.close() ;
    }
}