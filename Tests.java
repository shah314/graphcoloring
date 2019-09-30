
public class Tests {

	public static void main(String [] args) throws Exception
	{
		heuristicsTest(args);
		backtrackingTest(args);
	}
	
	public static void heuristicsTest(String [] args) throws Exception
	{
		String [] arguments = new String[3];
		arguments[0] = "./data.col";
		arguments[1] = "LOCAL_SEARCH=true";
		arguments[2] = "ITERATED_GREEDY_ITERATIONS=1000";
		int maxcolor = GraphColoring.colorGraph(arguments);
		if(maxcolor <= 11)
		{
			System.out.println("\n\n*** Heuristics TEST PASSED ! ***\n\n");
		}
		else
		{
			System.out.println("\n\n*** Heuristics TEST FAILED !!!! ***\n\n");
		}
	}
	
	public static void backtrackingTest(String [] args) throws Exception
	{
		String [] arguments = new String[2];
		arguments[0] = "./data.col";
		arguments[1] = "TIME=1000";
		
		int maxcolor = Backtracking.colorGraph(arguments);
		if(maxcolor <= 20)
		{
			System.out.println("\n\n*** Backtracking TEST PASSED ! ***\n\n");
		}
		else
		{
			System.out.println("\n\n*** Backtracking TEST FAILED !!!! ***\n\n");
		}
	}
}
