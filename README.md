<h1>Heuristic for Graph Coloring</h1>

<i><h3>Shalin Shah</h3></i>
<a href="https://zenodo.org/badge/latestdoi/134313250"><img src="https://zenodo.org/badge/134313250.svg" alt="DOI"></a>

<div align="center"><img src="threecoloring.jpg"/></div>
<p>
Implementation of the DSatur[1] heuristics for <A href="http://en.wikipedia.org/wiki/Graph_coloring_problem">graph coloring</a> in Java. The algorithm is created with tha aim of obtaining the best coloring, irrespective of run time. If you need to speed up the algorithm, consider not using local search. Also, if you need help with this, please open an issue.</p>

<p>
	The heuristic follows the following steps:
</p>
<ol>	
	<li>Compute a clique (maximum is good)
	<li>Color the clique
	<li>Sort the rest of the vertices in non-increasing order of the 
	degree of saturation
	<li>Color the vertices in the order given by 3. Also, when a vertex is 
	colored, change the degree of saturation of the neighboring vertices
	so that the order of coloring changes
	<li>Improve the coloring using Iterated Greedy techniques [2]
	<li>Improve the coloring using min-conflicts local search
	<li>Report the coloring
</ol>

<pre>
Compile the code:
javac *.java
(Please ignore the compilation warning, it is because the code does not use generics)

Then, run the algorithm using any of the two methods:

<b>Heuristics</b>
java GraphColoring filename
Example: java GraphColoring data.col

<b>Backtracking</b>
java Backtracking filename
Example: java Backtracking data.col

Please remove all comments (lines starting with a 'c') and other extraneous text from the file.

<b><i>Please run automatedtests.sh in the tests directory to test the code.</i></b>

(Please change the permissions of all .sh files to u+x i.e. run <b>chmod u+x *.sh</b>)

<b>Please see <a href="parameters.md">PARAMETERS</a> to see a list of parameters that can be passed in.</b>

Instances are available <a href="https://mat.tepper.cmu.edu/COLOR/instances.html">here</a> and <a href="http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm">here</a> in DIMACS format.
(The use of graphs in binary format is not yet supported).

(If you want to use the DIMACS formatted files on ColPack, please use DimacsToMatrix.java)

If you need to run the algorithm for <b>very large graphs</b>, 
please consider changing the following variables:
LOCAL_SEARCH_ITERATIONS
LOCAL_SEARCH_MAX_TIME
You may also consider not running local search at all, like <a href="https://github.com/smirarab/binning">this</a> user has 
done. 
To do this, pass in LOCAL_SEARCH=false to the java run.
If you need help, please open an issue.

<b>Please see <a href="parameters.md">PARAMETERS</a> to see a list of parameters that can be passed in.</b>
</pre>

<p>
[1] "New methods to color the vertices of a graph", Brelaz D., CACM 22(4) pp 251--256.<br>
[2] &quot;Iterated Greedy graph coloring and the difficulty landscape&quot;,
Culberson J. (See <a href="http://citeseer.ist.psu.edu/culberson92iterated.html">here</a>).
</p>

<b>Cited By:</b><ul><li>Mirarab, Siavash, et al. "Statistical binning enables an accurate coalescent-based estimation of the avian tree." Science 346.6215 (2014): 1250463. (<a href="http://science.sciencemag.org/content/sci/suppl/2014/12/11/346.6215.1250463.DC1/1250463.Mirarab.SM.revision1.pdf">PDF</a>)</li><li>https://github.com/smirarab/binning</li><li>Ahmad Muklason, "Hyper-heuristics and Fairness in Examination Timetabling Problems"</li></ul></li>

<p>The algorithm was run on a few <a href="https://mat.tepper.cmu.edu/COLOR/instances.html">benchmark instances</a> and the results are shown in the following table.</p>
  <table>
    <tr>
      <td   ><b>Instance</b></td>
      <td   ><b>Vertices</b></td>
      <td   ><b>Optimum</b></td>
      <td   ><b>Found - Best</b></td>
      <td   ><b>Found - Worst</b></td>
    </tr>
    <tr>
      <td  >fpsol2.i.1</td>
      <td  >496</td>
      <td  >65</td>
      <td  >65</td>
      <td  >65</td>
    </tr>
    <tr>
      <td  >fpsol2.i.2</td>
      <td  >451</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >fpsol2.i.3</td>
      <td  >425</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >inithx.i.1</td>
      <td  >864</td>
      <td  >54</td>
      <td  >54</td>
      <td  >54</td>
    </tr>
    <tr>
      <td  >inithx.i.2</td>
      <td  >645</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >inithx.i.3</td>
      <td  >621</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >*latin_square_10</td>
      <td  >900</td>
      <td  >-</td>
      <td  >124</td>
      <td  >125</td>
    </tr>
    <tr>
      <td  >le450_15b</td>
      <td  >450</td>
      <td  >15</td>
      <td  >18</td>
      <td  >18</td>
    </tr>
    <tr>
      <td  >le450_15c</td>
      <td  >450</td>
      <td  >15</td>
      <td  >25</td>
      <td  >25</td>
    </tr>
    <tr>
      <td  >le450_5a</td>
      <td  >450</td>
      <td  >5</td>
      <td  >6</td>
      <td  >6</td>
    </tr>
    <tr>
      <td  >le450_5b</td>
      <td  >450</td>
      <td  >5</td>
      <td  >7</td>
      <td  >7</td>
    </tr>
    <tr>
      <td  >le450_5c</td>
      <td  >450</td>
      <td  >5</td>
      <td  >7</td>
      <td  >7</td>
    </tr>
    <tr>
      <td  >le450_5d</td>
      <td width="92" >450</td>
      <td  >5</td>
      <td  >7</td>
      <td  >8</td>
    </tr>
    <tr>
      <td  >mulsol.i.1</td>
      <td width="92" >197</td>
      <td  >49</td>
      <td  >49</td>
      <td  >49</td>
    </tr>
    <tr>
      <td  >mulsol.i.2</td>
      <td width="92" >188</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >mulsol.i.3</td>
      <td width="92" >184</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >mulsol.i.4</td>
      <td width="92" >185</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >mulsol.i.5</td>
      <td width="92" >186</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >school1</td>
      <td width="92" >385</td>
      <td  >-</td>
      <td  >15</td>
      <td  >15</td>
    </tr>
    <tr>
      <td  >school1_nsh</td>
      <td width="92" >352</td>
      <td  >-</td>
      <td  >15</td>
      <td  >15</td>
    </tr>
    <tr>
      <td  >zeroin.i.1</td>
      <td width="92" >211</td>
      <td  >49</td>
      <td  >49</td>
      <td  >49</td>
    </tr>
    <tr>
      <td  >zeroin.i.2</td>
      <td width="92" >211</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >zeroin.i.3</td>
      <td width="92" >206</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >anna</td>
      <td width="92" >138</td>
      <td  >11</td>
      <td  >11</td>
      <td  >11</td>
    </tr>
    <tr>
      <td  >david</td>
      <td width="92" >87</td>
      <td  >11</td>
      <td  >11</td>
      <td  >11</td>
    </tr>
    <tr>
      <td  >homer</td>
      <td width="92" >561</td>
      <td  >13</td>
      <td  >13</td>
      <td  >13</td>
    </tr>
    <tr>
      <td  >huck</td>
      <td width="92" >74</td>
      <td  >11</td>
      <td  >11</td>
      <td  >11</td>
    </tr>
    <tr>
      <td  >jean</td>
      <td width="92" >80</td>
      <td  >10</td>
      <td  >10</td>
      <td  >10</td>
    </tr>
    <tr>
      <td  >games120</td>
      <td width="92" >120</td>
      <td  >9</td>
      <td  >9</td>
      <td  >9</td>
    </tr>
    <tr>
      <td  >miles1000</td>
      <td width="92" >128</td>
      <td  >42</td>
      <td  >42</td>
      <td  >42</td>
    </tr>
    <tr>
      <td  >miles1500</td>
      <td width="92" >128</td>
      <td  >73</td>
      <td  >73</td>
      <td  >73</td>
    </tr>
    <tr>
      <td  >miles250</td>
      <td width="92" >128</td>
      <td  >8</td>
      <td  >8</td>
      <td  >8</td>
    </tr>
    <tr>
      <td  >miles500</td>
      <td width="92" >128</td>
      <td  >20</td>
      <td  >20</td>
      <td  >20</td>
    </tr>
    <tr>
      <td  >miles750</td>
      <td width="92" >128</td>
      <td  >31</td>
      <td  >31</td>
      <td  >31</td>
    </tr>
    <tr>
      <td  >queen11_11</td>
      <td width="92" >121</td>
      <td  >11</td>
      <td  >14</td>
      <td  >14</td>
    </tr>
    <tr>
      <td  >queen13_13</td>
      <td width="92" >169</td>
      <td  >13</td>
      <td  >16</td>
      <td  >16</td>
    </tr>
    <tr>
      <td  >queen5_5</td>
      <td width="92" >25</td>
      <td  >5</td>
      <td  >5</td>
      <td  >5</td>
    </tr>
    <tr>
      <td  >queen6_6</td>
      <td width="92" >36</td>
      <td  >7</td>
      <td  >7</td>
      <td  >7</td>
    </tr>
    <tr>
      <td  >queen7_7</td>
      <td width="92" >49</td>
      <td  >7</td>
      <td  >7</td>
      <td  >7</td>
    </tr>
    <tr>
      <td  >queen8_12</td>
      <td width="92" >96</td>
      <td  >12</td>
      <td  >13</td>
      <td  >13</td>
    </tr>
    <tr>
      <td  >queen8_8</td>
      <td width="92" >64</td>
      <td  >9</td>
      <td  >10</td>
      <td  >10</td>
    </tr>
    <tr>
      <td  >queen9_9</td>
      <td width="92" >81</td>
      <td  >10</td>
      <td  >11</td>
      <td  >11</td>
    </tr>
    <tr>
      <td  >myciel3</td>
      <td width="92" >11</td>
      <td  >4</td>
      <td  >4</td>
      <td  >4</td>
    </tr>
    <tr>
      <td  >myciel4</td>
      <td width="92" >23</td>
      <td  >5</td>
      <td  >5</td>
      <td  >5</td>
    </tr>
    <tr>
      <td  >myciel5</td>
      <td width="92" >47</td>
      <td  >6</td>
      <td  >6</td>
      <td  >6</td>
    </tr>
    <tr>
      <td  >myciel6</td>
      <td width="92" >95</td>
      <td  >7</td>
      <td  >7</td>
      <td  >7</td>
    </tr>
    <tr>
      <td  >myciel7</td>
      <td width="92" >191</td>
      <td  >8</td>
      <td  >8</td>
      <td  >8</td>
    </tr>
  </table>
<i>* The algorithm was terminated before local search</i>
<br><br>
<p>The algorithm was run on a few more <a href="http://www.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm"> benchmark instances</a> and the results are shown
in the following table.</p>
  <table>
    <tr>
      <td   ><b>Instance</b></td>
      <td   ><b>Vertices</b></td>
      <td   ><b>Optimum</b></td>
      <td   ><b>Found - Best</b></td>
      <td   ><b>Found - Worst</b></td>
    </tr>
    <tr>
      <td  >frb30-15-1</td>
      <td  >450</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >frb30-15-2</td>
      <td  >450</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >frb30-15-3</td>
      <td  >450</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >frb30-15-4</td>
      <td  >450</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >frb30-15-5</td>
      <td  >450</td>
      <td  >30</td>
      <td  >30</td>
      <td  >30</td>
    </tr>
    <tr>
      <td  >frb50-23-1</td>
      <td  >1150</td>
      <td  >50</td>
      <td  >50</td>
      <td  >50</td>
    </tr>
    <tr>
      <td  >frb50-23-2</td>
      <td  >1150</td>
      <td  >50</td>
      <td  >50</td>
      <td  >50</td>
    </tr>
    <tr>
      <td  >frb50-23-3</td>
      <td  >1150</td>
      <td  >50</td>
      <td  >50</td>
      <td  >50</td>
    </tr>
    <tr>
      <td  >frb50-23-4</td>
      <td  >1150</td>
      <td  >50</td>
      <td  >50</td>
      <td  >50</td>
    </tr>
    <tr>
      <td  >frb50-23-5</td>
      <td  >1150</td>
      <td  >50</td>
      <td  >50</td>
      <td  >50</td>
    </tr>
    <tr>
      <td  >frb53-24-1</td>
      <td  >1272</td>
      <td  >53</td>
      <td  >53</td>
      <td  >53</td>
    </tr>
    <tr>
      <td  >frb53-24-2</td>
      <td  >1272</td>
      <td  >53</td>
      <td  >53</td>
      <td  >53</td>
    </tr>
    <tr>
      <td  >frb53-24-3</td>
      <td  >1272</td>
      <td  >53</td>
      <td  >53</td>
      <td  >53</td>
    </tr>
    <tr>
      <td  >frb53-24-4</td>
      <td  >1272</td>
      <td  >53</td>
      <td  >53</td>
      <td  >53</td>
    </tr>
    <tr>
      <td  >frb53-24-5</td>
      <td  >1272</td>
      <td  >53</td>
      <td  >53</td>
      <td  >53</td>
    </tr>
    <tr>
      <td  >frb56-25-1</td>
      <td  >1400</td>
      <td  >56</td>
      <td  >56</td>
      <td  >56</td>
    </tr>
    <tr>
      <td  >frb56-25-2</td>
      <td  >1400</td>
      <td  >56</td>
      <td  >56</td>
      <td  >56</td>
    </tr>
    <tr>
      <td  >frb56-25-3</td>
      <td  >1400</td>
      <td  >56</td>
      <td  >56</td>
      <td  >56</td>
    </tr>
    <tr>
      <td  >frb56-25-4</td>
      <td  >1400</td>
      <td  >56</td>
      <td  >56</td>
      <td  >56</td>
    </tr>
    <tr>
      <td  >frb56-25-5</td>
      <td  >1400</td>
      <td  >56</td>
      <td  >56</td>
      <td  >56</td>
    </tr>
    <tr>
      <td  >frb59-26-1</td>
      <td  >1534</td>
      <td  >59</td>
      <td  >59</td>
      <td  >59</td>
    </tr>
    <tr>
      <td  >frb59-26-2</td>
      <td  >1534</td>
      <td  >59</td>
      <td  >59</td>
      <td  >59</td>
    </tr>
    <tr>
      <td  >frb59-26-3</td>
      <td  >1534</td>
      <td  >59</td>
      <td  >59</td>
      <td  >59</td>
    </tr>
    <tr>
      <td  >frb59-26-4</td>
      <td  >1534</td>
      <td  >59</td>
      <td  >59</td>
      <td  >59</td>
    </tr>
    <tr>
      <td  >frb59-26-5</td>
      <td  >1534</td>
      <td  >59</td>
      <td  >59</td>
      <td  >59</td>
    </tr>
  </table>
</div>

<br>I ran <a href="https://github.com/CSCsw/ColPack">ColPack</a> (DISTANCE_ONE) on some of the publicly available data sets for comparison. The results are in the following table. On all of the instances, our algorithm is as good or better than the ColPack implementations. On the le450_5d and the queen9_9 instances, our method is able to achieve a better coloring of the graphs. 

About execution time, there are several parameters in Constants.java which can be used to control the run time. For instance, one could disable local search, or reduce the number of iterations and get a much better run time. On the inithx.i.3 instance with 621 vertices, this algorithm takes 2 seconds (without local search) and ColPack takes 45 milliseconds. But if the goal is to get a good enough coloring as fast as possible, the algorithm could be changed. Please open an issue if this is the case.
<br>
<table>
	<tr><td><b>DataSet</b></td><td>LARGEST_FIRST</td><td>SMALLEST_LAST</td><td>INCIDENCE_DEGREE</td><td>This Algorithm</td></tr>
	<tr><td>fpsol2.i.3</td><td>30</td><td>30</td><td>30</td><td>30</td></tr>
	<tr><td>inithx.i.3</td><td>31</td><td>31</td><td>32</td><td>31</td></tr>
	<tr><td><b>le450_5d</b></td><td>14</td><td>12</td><td>14</td><td><b>7</b></td></tr>
	<tr><td>mulsol.i.5</td><td>31</td><td>31</td><td>31</td><td>31</td></tr>
	<tr><td>zeroin.i.3</td><td>30</td><td>30</td><td>30</td><td>30</td></tr>
	<tr><td>games120</td><td>9</td><td>9</td><td>9</td><td>9</td></tr>
	<tr><td>miles750</td><td>32</td><td>31</td><td>32</td><td>31</td></tr>
	<tr><td><b>queen9_9</b></td><td>15</td><td>15</td><td>15</td><td><b>11</b></td></tr>
	<tr><td>myciel7</td><td>8</td><td>8</td><td>9</td><td>8</td></tr>
</table>
