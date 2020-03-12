package com.gcol;

import java.util.*;
import java.io.*;

/**
 * The graph on which the algorithm runs. 
 * An object of this class is created and populated by GraphReader.readGraph().
 *
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Graph {
    
    public  Node [] sortedNodes;
    public Node [] nodes;
    
    /** Creates a new instance of Graph */
    public Graph() 
    {
        sortedNodes = new Node[Constants.NUMBER_NODES];
        nodes = new Node[Constants.NUMBER_NODES];
        for(int i=0; i<Constants.NUMBER_NODES; i++)
        {
            nodes[i] = new Node(i);
            sortedNodes[i] = nodes[i];
        }
    }
    
    /* Sort the list of vertices based on their degrees in non-increasing order */
    public void sortList()
    {
        Arrays.sort(sortedNodes);
    }
    
    /* Get the array of sorted nodes. Used to create the initial greedy solution */
    public Node [] getSortedNodes()
    {
        return sortedNodes;
    }
    
    /* Add an edge to this graph */
    public void addEdge(int sv, int ev)
    {
        Node node = nodes[sv];
        if(node == null)
        {
            node = new Node(sv);
            nodes[sv] = node;
            node.addEdge(ev);
            sortedNodes[sv] = node;
            node.degree++;
        }
        else
        {
            node.addEdge(ev);
            node.degree++;
        }
        
        node = nodes[ev];
        if(node == null)
        {
            node = new Node(ev);
            nodes[ev] = node;
            node.addEdge(sv);
            sortedNodes[ev] = node;
            node.degree++;
        }
        else
        {
            node.addEdge(sv);
            node.degree++;
        }
    }
}
