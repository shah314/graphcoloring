<h1>Testing the graph coloring code</h1>

Please run <b>automatedtests.sh</b> in the tests directory to test the code.<br>

Please follow the following steps to test the code:

<b>Heuristics</b>

<ol>
<li>Please run test.sh. The algorithm will then run a cascaded list of steps:
<pre>
Reading Graph...
Computing Clique...
Maximum Clique Size Found: 9
Vertices in the Clique:
4 13 49 67 40 31 76 58 22 

46 milliseconds (excluding I/O).
15 coloring found using DSatur.
Applying Iterated Greedy Improvement...
Found Better Coloring - 12
Found Better Coloring - 11
Applying Local Search...
Final Coloring of graph possible with 11 colors.
Colors of Vertices: 
11 1 9 6 10 2 7 8 3 ...
Finished
</pre>
</li>
<li>The coloring should be around 11 (it might vary as the algorithm is randomized)</li>
</ol>

<b>Backtracking</b>

<ol>
  <li>Please run testbacktracking.sh. The algorithm will try to color the graph with increasing values of k.
  <pre>
  Reading Graph...
Computing Clique...
Maximum Clique Size Found: 9
Vertices in the Clique:
22 13 49 67 40 31 76 58 4 

55 milliseconds (excluding I/O).
Trying to color graph with 9 colors...
Trying to color graph with 10 colors...
Trying to color graph with 11 colors...
Trying to color graph with 12 colors...
Trying to color graph with 13 colors...

13 coloring found! Exiting...
Colors of Vertices: 
Final Coloring of graph possible with 13 colors.
Colors of Vertices: 
3 4 1 5 8 6 2 7 ....
Finished
  </pre>
  </li>
  <li>The coloring found will be slightly worse than using heuristics.</li>
</ol>
