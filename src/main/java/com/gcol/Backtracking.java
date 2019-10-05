package com.gcol;

import java.util.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Backtracking solver for the graph coloring problem.
 * Spends a specific amount of time (Constants.TIME) on trying to color the graph
 * using k colors after which it increments k by 1.
 * If k is known, it can be populated (Constants.KNOWN_K).
 * The time it spends on each k before incrementing it is very important for the performance of the
 * algorithm. For large graphs, the time should be increased to at least 10000 ms.
 * For small dense graphs, 2000 ms should work.
 *
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class Backtracking {

    /** Creates a new instance of GraphColoring */
    public Backtracking() {
    }

    public static void main(String [] args) throws Exception
    {
    	Options options = new Options();
    	Option o1 = new Option("f", true, "The DIMACS formatted graph file name");
    	o1.setRequired(false);
    	options.addOption(o1);
    	Option o2 = new Option("t", true, "Number of milliseconds to spend on each value of k");
    	o2.setRequired(false);
    	options.addOption(o2);

    	Option o6 = new Option("help", false, "This help message");
    	o6.setRequired(false);
    	options.addOption(o6);
    	Option o7 = new Option("h", false, "This help message");
    	o7.setRequired(false);
    	options.addOption(o7);
    	
    	CommandLineParser parser = new DefaultParser();
    	CommandLine cmd = parser.parse( options, args);
    	
    	if (!cmd.hasOption("f") || cmd.hasOption("help") || cmd.hasOption("h")) 
    	{
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("java -cp graphcoloring-1.7-jar-with-dependencies.jar com.gcol.Backtracking", options);
            System.exit(0);
    	}
    	
    	String filename = cmd.getOptionValue("f");
    	int milliseconds = Integer.parseInt(cmd.getOptionValue("t", "1000"));
    	System.out.println("Reading Graph...");
        /* Read the graph from Constants.FILE */
        Graph graph = GraphReader.readGraph(filename);
        
        int [] colors = colorGraph(graph, milliseconds);
        int maxColor = -1;
        for(int i=0; i<colors.length; i++)
        {
            if(maxColor == -1)
            {
                maxColor = colors[i];
            }
            else if(maxColor < colors[i])
            {
                maxColor = colors[i];
            }
        }
        
        System.out.println("Final Coloring of graph possible with " + maxColor + " colors.");
        System.out.println("Colors of Vertices: ");
        for(int i=0; i<colors.length; i++)
        {
            System.out.print(colors[i] + " ");
        }       
        
        System.out.println("\nFinished\n");
    }
    
    public static int [] colorGraph(Graph graph, int milliseconds) throws Exception
    {
    	Constants.TIME = milliseconds;
    	
    	/* Compute Clique */
        LinkedHashSet clique = MaxClique.computeClique(graph);

        /* Color the vertices of the clique with different colors */
        int k = clique.size();
        if(Constants.KNOWN_K > 0)
            k = Constants.KNOWN_K;

        Iterator it = clique.iterator();
        int col = 0;
        while(it.hasNext())
        {
            int vertex = ((Integer)it.next()).intValue();
            Node node = graph.nodes[vertex];
            node.colorNode(col);
            col++;
        }

        /* Try to color the nodes with increasing values of k */

        while(true)
        {
            List uncoloredNodes = new ArrayList();
            Node [] nodes = graph.nodes;

            for(int i=0; i<nodes.length; i++)
            {
                Node node = nodes[i];
                if(node.color == Constants.UNCOLORED)
                {
                    node.computePossibleColors(graph, k);
                    uncoloredNodes.add(node);
                }
            }

            PossibleColorsComparator comparator = new PossibleColorsComparator();
            Collections.sort(uncoloredNodes, comparator);
            Node previous = null;
            for(int i=0; i<uncoloredNodes.size();i++)
            {
                Node node = (Node)uncoloredNodes.get(i);
                if(previous == null)
                {
                    previous = node;
                    node.previous = null;
                }
                else
                {
                    previous.next = node;
                    node.previous = previous;
                    previous = node;
                }
            }
            Node head = (Node)uncoloredNodes.get(0);

            /* Try to color the uncolored nodes using k colors */
            Node current = (Node)uncoloredNodes.get(0);
            Node last = (Node)uncoloredNodes.get(uncoloredNodes.size()-1);
            boolean solved = false;
            System.out.println("Trying to color graph with " + k + " colors...");
            long startTime = System.currentTimeMillis();
            while(true)
            {
                long endTime = System.currentTimeMillis();
                if((endTime-startTime) > Constants.TIME)
                {
                    solved = false;
                    break;
                }

                if(current == last)
                {
                    int nextColor = current.nextColor();
                    while(nextColor != Constants.UNCOLORED && !current.isValidColor(graph, nextColor))
                    {
                        nextColor = current.nextColor();
                    }

                    if(nextColor == Constants.UNCOLORED)
                    {
                        current.resetColorCount();
                        current = current.previous;
                    }
                    else
                    {
                        /* Solved */
                        current.colorNode(nextColor);
                        System.out.println("\n" + k + " coloring found! Exiting...");
                        solved = true;
                        break;
                    }
                }
                else
                {
                    int nextColor = current.nextColor();
                    while(nextColor != Constants.UNCOLORED && !current.isValidColor(graph, nextColor))
                    {
                        nextColor = current.nextColor();
                    }

                    if(nextColor == Constants.UNCOLORED)
                    {
                        current.resetColorCount();
                        current = current.previous;
                        if(current == null)
                        {
                            solved = false;
                            break;
                        }
                    }
                    else
                    {
                        current.colorNode(nextColor);
                        current = current.next();
                    }
                }
            }

            if(solved)
            {
                break;
            }
            else
            {
                k++;
            }
        }
        
        System.out.println("Colors of Vertices: ");
        int [] colors = new int [Constants.NUMBER_NODES];
        for(int i=0; i<graph.nodes.length; i++)
        {
        	colors[i] = graph.nodes[i].color;
        }
        
        return colors;
    }

    public static class PossibleColorsComparator implements Comparator
    {
        public int compare(Object o1, Object o2)
        {
            Node node1 = (Node)o1;
            Node node2 = (Node)o2;
            if(node1.possibleColors.size() < node2.possibleColors.size())
            {
                return 1;
            }
            else if(node1.possibleColors.size() > node2.possibleColors.size())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
}
