#!/bin/bash
mkdir testing1
cd testing1
cp ../../*.java .
javac *.java
cp ../data.col .
java GraphColoring
cd ..
rm testing1/*.java
rm testing1/*.class
rm testing1/data.col
rmdir testing1
