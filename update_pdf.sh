#!/bin/bash

for file in /mnt/c/Users/Zhenhao/OneDrive/Documents/CS2040S/*.pdf
do 
    dir=$(echo $file | sed -e "s/.*\///g" | sed -e "s/\.pdf//g")
    cp $file ./$dir/
done