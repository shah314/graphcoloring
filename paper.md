---
title: 'GraphColoring: A Java package for solving the graph coloring problem'
tags:
  - Java
  - graph coloring
  - maximum clique
  - solver
  - dsatur
  - iterated greedy
  - min-conflicts local search
authors:
  - name: Shalin Shah
    orcid: 0000-0002-3770-1391
    affiliation: 1
affiliations:
 - name: Johns Hopkins University
   index: 1
date: 12 September 2019
bibliography: paper.bib
---

# Summary

![Three Coloring.](threecoloring.jpg)

The graph coloring problem aims at assigning colors to the nodes of a graph such that no two connected nodes have the same color. The graph coloring problem is NP-complete and one of the harder problems to solve. We present a heuristic to solve it using three cascaded algorithms. The graph coloring problem was one of Karp's 21 NP-complete problems, and is also know as the problem of finding the chromatic number of a graph. Several other problems reduce to graph coloring including solving generalized Sudoku puzzles.

This Java code uses the DSATUR [@brelaz1979new] heuristics along with iterated greedy heuristics [@culberson1992iterated] to color a graph. The DSATUR heuristic orders the nodes of a graph in non-increasing order of the degree of saturation. The degree of saturation is the number of colors found in the adjacency list of a node. The iterated greedy heuristics perform randomized ordering of the vertices to color them in that order. By randomizing this process, improvement can be found in successive iterations. The algorithm then uses min-conflicts local search to improve the coloring. The method is quite successful in finding good colorings of the majority of the publicly available data sets. Results can be found on the git page.

The method uses the following steps:

1) Compute a clique (maximum is good)
2) Color the clique
3) Sort the rest of the vertices in non-increasing order of the degree of saturation
4) Color the vertices in the order given by 3. Also, when a vertex is colored, change the degree of saturation of the neighboring vertices so that the order of coloring changes
5) Improve the coloring using Iterated Greedy techniques
6) Improve the coloring using min-conflicts local search
7) Report the coloring

The Java code and a description are available here: <https://github.com/shah314/graphcoloring>. 

The problem instances are available here: 
<https://mat.gsia.cmu.edu/COLOR/instances.html> and 
<http://sites.nlsde.buaa.edu.cn/~kexu/benchmarks/graph-benchmarks.htm>.

# References