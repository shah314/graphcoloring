import java.util.*;
import java.io.*;

public class DimacsToMatrix {

	public static void main(String [] args) throws Exception
	{
		String inputfile = args[0];
		String outputfile = args[1];
		
		BufferedReader input = new BufferedReader(new FileReader(new File(inputfile)));
		BufferedWriter output = new BufferedWriter(new FileWriter(new File(outputfile)));
		output.write("%%MatrixMarket matrix coordinate real general\n");
		String line = input.readLine();
		
		while(line != null)
		{
			if(line.charAt(0) == 'p')
			{
				String [] split = line.split("\\s|\t");
				String nodes = split[2];
				String edges = split[3];
				output.write("" + nodes + "\t" + nodes + "\t" + edges + "\n");
			}
			else if(line.charAt(0) == 'c')
			{
				// comment
			}
			else
			{
				String [] split = line.split("\\s|\t");
				output.write(split[1] + "\t" + split[2] + "\t1.0\n");
			}
			
			line = input.readLine();
		}
		
		input.close();
		output.close();
	}
}
