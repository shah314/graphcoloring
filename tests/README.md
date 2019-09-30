<h1>Testing the graph coloring code</h1>

Please run <b>testsautomated.sh</b> in the tests directory to test the code.
(Please change the permissions of all .sh files to u+x i.e. run chmod u+x *.sh)

Please follow the following steps to test the code:

<ol>
<li>Use the data.col (queen9_9) file in this directory and copy it to the directory where the source code is</li>
<li>Compile the Java code</li>
<li>Run "java GraphColoring data.col" for the heuristic algorithms (test.sh)</li>
<li>The algorithm should then follow a cascaded run of various steps:
<pre>
Reading Graph...
Computing Clique...
Maximum Clique Size Found: 9
Vertices in the Clique:
22 18 21 25 20 19 26 23 24 

47 milliseconds (excluding I/O).
15 coloring found using DSatur.
Applying Iterated Greedy Improvement...
Found Better Coloring - 12
Applying Local Search...
Found Better Coloring - 11
Final Coloring of graph possible with 11 colors.
Colors of Vertices: 
2 4 1 5 9 11 7 8 6 9 10 6 7 2 ...</pre>
</li>
<li>The coloring should be around 11 (it might vary as the algorithm is randomized)</li>
<li>(Alternatively, run "java Backtracking data.col" for the backtracking algorithm (testbacktracking.sh))</li>
</ol>
