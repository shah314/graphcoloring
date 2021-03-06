# JCOL: A Java package for solving the graph coloring problem

## Shalin Shah

[![status](https://joss.theoj.org/papers/07cf7b3c7dc9037ad19f0b2ae81cde14/status.svg)](https://joss.theoj.org/papers/07cf7b3c7dc9037ad19f0b2ae81cde14)

![Three Coloring](threecoloring.jpg)

Implementation of the three heuristic algorithms including DSatur[1], Iterated Greedy [2] and min-conflicts local search in a mixed strategy (randomized) for graph coloring in Java. The algorithm is created with tha aim of obtaining the best coloring, irrespective of run time. If you need to speed up the algorithm, consider not using local search. Also, if you need help with this, please open an issue.

The heuristic follows the following steps:

	Compute a clique (maximum is good)
	Color the clique
	Sort the rest of the vertices in non-increasing order of the degree of saturation
	Color the vertices in the order given by 3. Also, when a vertex is colored, change the degree of saturation of the neighboring vertices so that the order of coloring changes
	Improve the coloring using Iterated Greedy techniques [2]
	Improve the coloring using min-conflicts local search
	Report the coloring
	
[1]"New methods to color the vertices of a graph", Brelaz D., CACM 22(4) pp 251--256

[2]"Iterated Greedy graph coloring and the difficulty landscape", Culberson J

### Cite this work
	@article{shah2020jcol,
	  doi = {10.21105/joss.01843},
	  url = {https://doi.org/10.21105/joss.01843},
	  year = {2020},
	  publisher = {The Open Journal},
	  volume = {5},
	  number = {48},
	  pages = {1843},
	  author = {Shalin Shah},
	  title = {JCOL: A Java package for solving the graph coloring problem},
	  journal = {Journal of Open Source Software}
	}


### Maven is needed to compile and package the code. 
For e.g. you might run "brew install maven" on a Mac.
Compile the code using Maven:

	mvn package

(Please ignore the compilation warnings, it is because the code does not use generics)

Then, run the algorithm using any of the two methods:

### Heuristics

	java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring -f data.col

	java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring
	usage: java -cp graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring
	 -f <arg>   The DIMACS formatted graph file name
	 -h         This help message
	 -help      This help message
	 -i <arg>   Number of iterated greedy iterations
	 -j <arg>   Number of local search iterations
	 -l <arg>   Enable local search true/false
	 -m <arg>   Number of milliseconds to spend on local search
	 -v <arg>   Verbose true/false

### Backtracking

	java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.Backtracking -f data.col

	java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.Backtracking
	usage: java -cp graphcoloring-1.7-jar-with-dependencies.jar com.gcol.Backtracking
	 -f <arg>   The DIMACS formatted graph file name
	 -h         This help message
	 -help      This help message
	 -t <arg>   Number of milliseconds to spend on each value of k
	 -v <arg>   Verbose true/false

Please remove all comments (lines starting with a 'c') and other extraneous text from the file.

### Please run automatedtests.sh in the tests directory to test the code.

Instances are available [here](https://mat.tepper.cmu.edu/COLOR/instances.html) and [here](http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm) in DIMACS format.
(The use of graphs in binary format is not yet supported).

(If you want to use the DIMACS formatted files on ColPack, please use DimacsToMatrix.java)

### Very Large Graphs
If you need to run the algorithm for very large graphs, please consider setting local search to false.
	
	java -cp target/graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring -f data.col -l false

If you need help, please open an issue.

### If you want to call the code as an API, please see [API](api.md).

### Cited By:

1) Mirarab, Siavash, et al. "Statistical binning enables an accurate coalescent-based estimation of the avian tree." Science 346.6215 (2014): 1250463. 
2) [https://github.com/smirarab/binning/](https://github.com/smirarab/binning/)
3) Ahmad Muklason, Hyper-heuristics and Fairness in Examination Timetabling Problems

### The algorithm was run on a few [benchmark instances](https://mat.tepper.cmu.edu/COLOR/instances.html) and the results are shown in the following table. The algorithm was run 10 times and the best and the worst results are shown.

|||||||
|--- |--- |--- |--- |--- |--- |
|Instance|Vertices|Optimum|Found - Best|Found - Worst|Edges
|fpsol2.i.1|496|65|65|65|11654|
|fpsol2.i.2|451|30|30|30|8691|
|fpsol2.i.3|425|30|30|30|8688|
|inithx.i.1|864|54|54|54|18707|
|inithx.i.2|645|31|31|31|13979|
|inithx.i.3|621|31|31|31|13969|
|*latin_square_10|900|-|124|125|307350|
|le450_15b|450|15|18|18|8169|
|le450_15c|450|15|25|25|16680|
|le450_5a|450|5|6|6|5714|
|le450_5b|450|5|7|7|5734|
|le450_5c|450|5|7|7|9803|
|le450_5d|450|5|7|8|9757|
|mulsol.i.1|197|49|49|49|3925|
|mulsol.i.2|188|31|31|31|3885|
|mulsol.i.3|184|31|31|31|3916|
|mulsol.i.4|185|31|31|31|3946|
|mulsol.i.5|186|31|31|31|3973|
|school1|385|-|15|15|19095|
|school1_nsh|352|-|15|15|14612|
|zeroin.i.1|211|49|49|49|4100|
|zeroin.i.2|211|30|30|30|3541|
|zeroin.i.3|206|30|30|30|3540|
|anna|138|11|11|11|493|
|david|87|11|11|11|406|
|homer|561|13|13|13|1629|
|huck|74|11|11|11|301|
|jean|80|10|10|10|254|
|games120|120|9|9|9|638|
|miles1000|128|42|42|42|3216|
|miles1500|128|73|73|73|5198|
|miles250|128|8|8|8|387|
|miles500|128|20|20|20|1170|
|miles750|128|31|31|31|2113|
|queen11_11|121|11|14|14|3960|
|queen13_13|169|13|16|16|6656|
|queen5_5|25|5|5|5|160|
|queen6_6|36|7|7|7|290|
|queen7_7|49|7|7|7|476|
|queen8_12|96|12|13|13|1368|
|queen8_8|64|9|10|10|728|
|queen9_9|81|10|11|11|2112|
|myciel3|11|4|4|4|20|
|myciel4|23|5|5|5|71|
|myciel5|47|6|6|6|236|
|myciel6|95|7|7|7|755|
|myciel7|191|8|8|8|2360|
  
* The algorithm was terminated before local search

### The algorithm was run on a few more [benchmark instances](http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm) and the results are shown in the following table.

||||||
|--- |--- |--- |--- |--- |
|Instance|Vertices|Optimum|Found - Best|Found - Worst|
|frb30-15-1|450|30|30|30|
|frb30-15-2|450|30|30|30|
|frb30-15-3|450|30|30|30|
|frb30-15-4|450|30|30|30|
|frb30-15-5|450|30|30|30|
|frb50-23-1|1150|50|50|50|
|frb50-23-2|1150|50|50|50|
|frb50-23-3|1150|50|50|50|
|frb50-23-4|1150|50|50|50|
|frb50-23-5|1150|50|50|50|
|frb53-24-1|1272|53|53|53|
|frb53-24-2|1272|53|53|53|
|frb53-24-3|1272|53|53|53|
|frb53-24-4|1272|53|53|53|
|frb53-24-5|1272|53|53|53|
|frb56-25-1|1400|56|56|56|
|frb56-25-2|1400|56|56|56|
|frb56-25-3|1400|56|56|56|
|frb56-25-4|1400|56|56|56|
|frb56-25-5|1400|56|56|56|
|frb59-26-1|1534|59|59|59|
|frb59-26-2|1534|59|59|59|
|frb59-26-3|1534|59|59|59|
|frb59-26-4|1534|59|59|59|
|frb59-26-5|1534|59|59|59|

## ColPack comparison

I ran [ColPack](https://github.com/CSCsw/ColPack) (DISTANCE_ONE) on some of the publicly available data sets for comparison. The results are in the following table. On all of the instances, our algorithm is as good or better than the ColPack implementations. On the le450_5d and the queen9_9 instances, our method is able to achieve a better coloring of the graphs. 

About execution time, there are several parameters which can be used to control the run time. For instance, one could disable local search, or reduce the number of iterations and get a much better run time. On the inithx.i.3 instance with 621 vertices, this algorithm takes 2 seconds (1000 iterations, without local search) and ColPack takes 45 milliseconds. But if the goal is to get a good enough coloring as fast as possible, the algorithm could be changed. Please open an issue if this is the case.

The following table shows the results and the time it takes for JCOL (100 iterations, no local search) and ColPack on some benchmarks.

||||||||
|--- |--- |--- |--- |--- |--- |--- |
|DataSet|LARGEST FIRST|SMALLEST LAST|INCIDENCE DEGREE|This Algorithm|ColPack(ms)|JCOL(ms)
|fpsol2.i.3|30|30|30|30|32|430
|inithx.i.3|31|31|32|31|36|457
|le450_5d|14|12|14|7|33|361
|mulsol.i.5|31|31|31|31|38|342
|zeroin.i.3|30|30|30|30|30|332
|games120|9|9|9|9|30|229
|miles750|32|31|32|31|31|276
|queen9_9|15|15|15|11|30|218
|myciel7|8|8|9|8|30|569

## References

[1] Brélaz, D. (1979). New methods to color the vertices of a graph. Communications of the ACM, 22(4), 251–256. doi:10.1145/359094.359101

[2] Culberson, J. (1992). Iterated greedy graph coloring and the difficulty landscape. doi:10.7939/R3M32NH6Q

[3] Gebremedhin, A., Nguyen, D., Patwary, M., & Pothen, A. (2010). ColPack: Software for graph coloring and related problems in scientific computing. Submitted to ACM TOMS. doi:10.1145/2513109.2513110

[4] Malaguti, E., & Toth, P. (2010). A survey on vertex coloring problems. International transactions in operational research, 17(1), 1–34. doi:10.1111/j.1475-3995.2009.00696.x
