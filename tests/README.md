<h1>Testing the graph coloring code</h1>

Please follow the following steps to test the code:

<ol>
<li>Use the data.col file in this directory and copy it to the directory where the source code is</li>
<li>Compile the Java code</li>
<li>Run "java GraphColoring" for the heuristic algorithms (test.sh)</li>
<li>The algorithm should then follow a cascaded run of various steps:
<pre>
Reading Graph...
Computing Clique...
Maximum Clique Size Found: 43
Vertices in the Clique:
1 90 92 94 106 109 113 116 119 121 167 54 58 181 ....

160 milliseconds (excluding I/O).
65 coloring found using DSatur.
Applying Iterated Greedy Improvement...
Applying Local Search...
Final Coloring of graph possible with 65 colors.
Colors of Vertices: 
22 1 19 17 18 15 14 13 12 11 20 32 42 37 ....
</pre>
</li>
<li>The coloring should be around 65 (it might vary as the algorithm is randomized)</li>
<li>(Alternatively, run "java Backtracking" for the backtracking algorithm (testbacktracking.sh))</li>
</ol>
