
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
		int [] colors = Backtracking.colorGraph(graph, millisecondsperK, false);

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

	}
}
