#!/bin/bash -v
cd ..
mvn package
java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.Tests
