#!/bin/bash

for char in A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
do 
	className=Character$char
	fileName=$className.java
	
	echo "package com.sensei.banner.characters;" > $fileName
	echo "" >> $fileName
	echo "import com.sensei.banner.Character;" >> $fileName
	echo "" >> $fileName
	echo "public class $className extends Character {" >> $fileName
	echo "" >> $fileName

    banner $char
    row=0
    IFS='
'
    echo  "    public $className() {"   >> $fileName                        
    echo  "        initializeBitmap("   >> $fileName   
    for line in $(banner $char)
    do
        if [ "$row" -lt 6 ];
        then
            echo "            \"$line\"," >> $fileName
        else
            echo "            \"$line\"" >> $fileName
        fi
        row=$((row+1))
    done
    echo  "        ) ;"                 >> $fileName          
    echo  "    }"                       >> $fileName    

	echo "}" >> $fileName
	echo "$className created"
done

