<h1>Graph Coloring Parameters</h1>

The usage of the Java code is as follows:
<br>
<pre>
java GraphColoring filename [optional parameters]
</pre>

<pre>
The typical configuration can be run as under:

For heuristics:
<i>java GraphColoring data.col LOCAL_SEARCH=true ITERATED_GREEDY_ITERATIONS=1000</i>

For backtracking:
<i>java Backtracking data.col TIME=1000</i>

The optional parameters (with default values):

<b>LOCAL_SEARCH=true</b>
Please set this to true to get the best coloring possible.
If the speed of coloring is critical, please set this to false.

<b>LOCAL_SEARCH_ITERATIONS=1000</b>
This parameter controls the number of local search iterations.
Please leave this to 1000 if speed is not critical.
Please increase this to a much larger value if you want the code to spend 
a few hours in trying to find a good coloring.

<b>LOCAL_SEARCH_MAX_TIME=1000</b>
This parameter controls (to some extent) the number of milliseconds to spend on local search.
1000 should be a good value, but please increase this to a much larger value if time is not critical.

<b>ITERATED_GREEDY_ITERATIONS=1000</b>
Please leave it to 1000 for a moderately fast algorithm.
Please increase this to a much larger value, if all you seek is a good coloring as oppoosed to speed.

<b>TIME=1000</b>
This parameter, in milliseconds, controls how much time is spent on each k in the Backtracking algorithm.
Please leave this to 1000 if time is critical.
Please increase this to a much higher value, if time is not critical and you can spend several minutes 
to several hours on the coloring.
</pre>
