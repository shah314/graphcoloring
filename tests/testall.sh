#!/bin/bash -v
mkdir testing1
cd testing1
cp ../../*.java .
javac *.java
cp ../data.col .
java GraphColoring data.col
java Backtracking data.col
