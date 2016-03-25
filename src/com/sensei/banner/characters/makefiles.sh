#!/bin/bash

for char in A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
do 
	className=Character$char
	fileName=$className.java

	echo "package com.sensei.banner.characters;" >> $fileName
	echo "" >> $fileName
	echo "import com.sensei.banner.Character;" >> $fileName
	echo "" >> $fileName
	echo "public class $className extends Character {" >> $fileName
	echo "" >> $fileName
	echo "    public void print() {" >> $fileName
	
	banner $char
	IFS='
'
	for line in $(banner $char)
	do
		echo "        System.out.println( \"$line\" );" >> $fileName
	done

	echo "    }" >> $fileName
	echo "}" >> $fileName
	echo "$className created"
done

