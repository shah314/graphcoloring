<h1>Using the code as an API</h1>

Please include target/graphcoloring-1.7-jar-with-dependencies.jar in the classpath.

<h2>Heuristics</h2>

```Java

import com.gcol.GraphColoring;
import com.gcol.GraphReader;
import com.gcol.Graph;

public class APICallHeuristics 
{
	public static void main(String [] args) throws Exception
	{
		Graph graph = GraphReader.readGraph("filename");
		// where filename is a DIMACS formatted graph file
		boolean localsearch = true;
		int iteratedgreedyiterations = 1000;
		int localsearchiterations = 1000;
		int localsearchtimeinmilliseconds = 1000;
		int [] colors = GraphColoring.colorGraph(graph, localsearch, iteratedgreedyiterations, localsearchiterations, localsearchtimeinmilliseconds);

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
		    System.out.print(graph.nodes[i].value + ":" + colors[i] + ",");
		}

	}
}
```

<h2>Backtracking</h2>

```Java

import com.gcol.Backtracking;
import com.gcol.GraphReader;
import com.gcol.Graph;

public class APICallBacktracking 
{
	public static void main(String [] args) throws Exception
	{
		Graph graph = GraphReader.readGraph("filename");
		// where filename is a DIMACS formatted graph file
		int millisecondsperK = 1000;
		int [] colors = Backtracking.colorGraph(graph, millisecondsperK);

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
			System.out.print(graph.nodes[i].value + ":" + colors[i] + ",");
		}

	}
}
```
