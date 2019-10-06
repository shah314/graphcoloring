import com.gcol.GraphColoring;
import com.gcol.GraphReader;
import com.gcol.Graph;

public class APICallHeuristics 
{
	public static void main(String [] args) throws Exception
	{
		Graph graph = GraphReader.readGraph("data.col");
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
		    System.out.print((graph.nodes[i].value+1) + ":" + colors[i] + ",");
		}

	}
}
