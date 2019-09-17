#!/bin/bash
mkdir testing1
cd testing1
cp ../../*.java .
javac *.java
cp ../data.col .
java GraphColoring
rm *
cd ..
rmdir testing1
