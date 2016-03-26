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

    public void printBanner( String string ) {
        
        String text = string.toUpperCase() ;
        for( int i=text.length()-1; i>=0; i-- ) {
            
            char      ch    = text.charAt(i) ;
            int       index = ch - 'A' ;
            Character c     = characters[index] ;
            
            c.print();
            System.out.println();
            
        }
    }
    
    public static void main(String[] args) {
        
        Banner banner = new Banner() ;
        banner.loadCharacters() ;
        banner.printBanner( "Deba" ) ;
    }
}