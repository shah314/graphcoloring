
public class Tests {

	public static void main(String [] args) throws Exception
	{
		heuristicsTest();
		backtrackingTest();
	}
	
	public static void heuristicsTest() throws Exception
	{
		Graph graph = GraphReader.readGraph("./data.col");
		int [] colors = GraphColoring.colorGraph(graph, true, 1000, 1000, 1000);
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
		
		if(maxColor <= 11)
		{
			System.out.println("\n\n*** Heuristics TEST PASSED ! ***\n\n");
		}
		else
		{
			System.out.println("\n\n*** Heuristics TEST FAILED !!!! ***\n\n");
		}
	}
	
	public static void backtrackingTest() throws Exception
	{
		Graph graph = GraphReader.readGraph("./data.col");
		int [] colors = Backtracking.colorGraph(graph, 1000);
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
		
		if(maxColor <= 20)
		{
			System.out.println("\n\n*** Backtracking TEST PASSED ! ***\n\n");
		}
		else
		{
			System.out.println("\n\n*** Backtracking TEST FAILED !!!! ***\n\n");
		}
	}
}
