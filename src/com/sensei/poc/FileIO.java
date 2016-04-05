package com.sensei.poc;

import java.io.*;

public class FileIO {

   public static void main(String args[])throws IOException{

      File file = new File("/home/sensei/test.txt");

      if( !file.exists() ) {
          file.createNewFile();
      }
      
      FileWriter writer = new FileWriter(file, true); 
      writer.write("Test\n"); 
      writer.flush();
      writer.close();

      FileReader fr = new FileReader(file); 
      char[] a = new char[50];
      fr.read(a); 
      for(char c : a)
          System.out.print(c); 
      fr.close();
   }
}