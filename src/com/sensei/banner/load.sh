#!/bin/bash

count=0
for char in A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
do 
	echo "characters[$count] = new Character$char();"
	count=$((count+1))
done