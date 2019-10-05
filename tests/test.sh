#!/bin/bash -v
cd ..
mvn package
java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring -f data.col -i 1000 -l true -j 1000 -m 1000
