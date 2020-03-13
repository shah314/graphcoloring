package com.gcol;

import java.util.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Implementation of the DSatur heuristic for graph coloring.
 *
 * @author Shalin Shah
 * Email: shah.shalin@gmail.com
 */
public class GraphColoring {

    /** Creates a new instance of GraphColoring */
    public GraphColoring() {
    }

    public static void main(String [] args) throws Exception
    {
    	Options options = new Options();
    	Option o1 = new Option("f", true, "The DIMACS formatted graph file name");
    	o1.setRequired(false);
    	options.addOption(o1);
    	Option o2 = new Option("l", true, "Enable local search true/false" );
    	o2.setRequired(false);
    	options.addOption(o2);
    	Option o3 = new Option("i", true, "Number of iterated greedy iterations");
    	o3.setRequired(false);
    	options.addOption(o3);
    	Option o4 = new Option("j", true, "Number of local search iterations");
    	o4.setRequired(false);
    	options.addOption(o4);
    	Option o5 = new Option("m", true, "Number of milliseconds to spend on local search");
    	o5.setRequired(false);
    	options.addOption(o5);

    	Option o6 = new Option("help", false, "This help message");
    	o6.setRequired(false);
    	options.addOption(o6);
    	Option o7 = new Option("h", false, "This help message");
    	o7.setRequired(false);
    	options.addOption(o7);
    	Option o8 = new Option("v", true, "Verbose true/false");
    	o8.setRequired(false);
    	options.addOption(o8);
    	
    	CommandLineParser parser = new DefaultParser();
    	CommandLine cmd = parser.parse( options, args);

    	if (!cmd.hasOption("f") || cmd.hasOption("help") || cmd.hasOption("h"))
    	{
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("java -cp graphcoloring-1.7-jar-with-dependencies.jar com.gcol.GraphColoring", options);
            System.exit(0);
    	}

    	String filename = cmd.getOptionValue("f");
    	boolean localsearch = Boolean.parseBoolean(cmd.getOptionValue("l", "true"));
    	int numiteratedgreedy = Integer.parseInt(cmd.getOptionValue("i", "1000"));
    	int numlocalsearch = Integer.parseInt(cmd.getOptionValue("j", "1000"));
    	int numlocaltime = Integer.parseInt(cmd.getOptionValue("m", "1000"));

    	System.out.println("Reading Graph...");
        Graph graph = GraphReader.readGraph(filename);
        boolean verbose = false;
        if(cmd.hasOption("v"))
        {
        	verbose = Boolean.parseBoolean(cmd.getOptionValue("v"));
        }
        
        int [] colors = colorGraph(graph, localsearch, numiteratedgreedy, numlocalsearch, numlocaltime, verbose);
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

    public static int [] colorGraph(Graph graph, boolean localsearch, int iteratedgreedyiterations, int localsearchiterations, int localsearchtime, boolean verbose) throws Exception
    {
    	Constants.LOCAL_SEARCH = localsearch;
    	Constants.ITERATED_GREEDY_ITERATIONS = iteratedgreedyiterations;
    	Constants.LOCAL_SEARCH_ITERATIONS = localsearchiterations;
    	Constants.LOCAL_SEARCH_MAX_TIME = localsearchtime;

        /* Compute Clique */
        LinkedHashSet clique = MaxClique.computeClique(graph);

        /* Color the vertices of the clique with different colors */
        int k = clique.size();
        Iterator it = clique.iterator();
        int col = 1;
        while(it.hasNext())
        {
            int vertex = ((Integer)it.next()).intValue();
            Node node = graph.nodes[vertex];
            node.colorNode(col);
            col++;
        }

        Node [] nodes = graph.nodes;
        PossibleColorsComparator comparator = new PossibleColorsComparator();
        TreeSet uncoloredNodes = new TreeSet(comparator);
        List listNodes = new ArrayList();
        LinkedHashSet flags = new LinkedHashSet();
        for(int i=0; i<nodes.length; i++)
        {
            Node node = nodes[i];
            if(node.color == Constants.UNCOLORED)
            {
                node.computeDegreeSat(graph);
                uncoloredNodes.add(node);
                listNodes.add(node);
                flags.add(new Integer(node.value));
            }
        }

        while(!uncoloredNodes.isEmpty())
        {
            Node node = (Node)uncoloredNodes.first();
            uncoloredNodes.remove(node);
            flags.remove(new Integer(node.value));
            //System.out.println(uncoloredNodes.size());
            for(int i=1; ;i++)
            {
                if(node.isValidColor(graph, i))
                {
                    node.colorNode(i);
                    LinkedHashSet list = node.list;
                    it = list.iterator();
                    while(it.hasNext())
                    {
                        int vertex = ((Integer)it.next()).intValue();
                        Node n = graph.nodes[vertex];

                        if(uncoloredNodes.contains(n))
                        {
                            uncoloredNodes.remove(n);
                            n.computeDegreeSat(graph);
                            uncoloredNodes.add(n);
                        }
                    }

                    if(i > k)
                    {
                        k = i;
                    }
                    break;
                }
            }
        }

        System.out.println(k + " coloring found using DSatur.");
        System.out.println("Applying Iterated Greedy Improvement...");

        int [] colors = IteratedGreedy.iteratedGreedy(k, graph, verbose);
        int maxColor = -1;
        for(int i=0; i<colors.length; i++)
        {
            graph.nodes[i].color = colors[i];
            if(maxColor == -1)
            {
                maxColor = colors[i];
            }
            else if(maxColor < colors[i])
            {
                maxColor = colors[i];
            }
        }

        if(Constants.LOCAL_SEARCH)
        {
	        System.out.println("Applying Local Search...");
	        colors = LocalSearch.localSearch(graph, maxColor, verbose);
	        maxColor = -1;
	        for(int i=0; i<colors.length; i++)
	        {
              graph.nodes[i].color = colors[i];
	            if(maxColor == -1)
	            {
	                maxColor = colors[i];
	            }
	            else if(maxColor < colors[i])
	            {
	                maxColor = colors[i];
	            }
	        }
        }

        return colors;
    }

    public static class PossibleColorsComparator implements Comparator
    {
        public int compare(Object o1, Object o2)
        {
            Node node1 = (Node)o1;
            Node node2 = (Node)o2;

            if(node1.value == node2.value)
            {
                return 0;
            }

            if(node1.degreeSat < node2.degreeSat)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}
