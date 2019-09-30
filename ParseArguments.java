
public class ParseArguments {

	public static void parse(String [] args)
	{
		for(int i=1; i<args.length; i++)
		{
			String argument = args[i].trim();
			String [] split = argument.split("=");
			String name = split[0];
			String value = split[1];
			if(name.equals("LOCAL_SEARCH_ITERATIONS"))
			{
				int intvalue = Integer.parseInt(value);
				Constants.LOCAL_SEARCH_ITERATIONS = intvalue;
			}
			else if(name.equals("LOCAL_SEARCH_MAX_TIME"))
			{
				int intvalue = Integer.parseInt(value);
				Constants.LOCAL_SEARCH_MAX_TIME = intvalue;
			}
			else if(name.equals("ITERATED_GREEDY_ITERATIONS"))
			{
				int intvalue = Integer.parseInt(value);
				Constants.ITERATED_GREEDY_ITERATIONS = intvalue;
			}
			else if(name.equals("LOCAL_SEARCH"))
			{
				Constants.LOCAL_SEARCH = Boolean.parseBoolean(value);
			}
			else if(name.equals("TIME"))
			{
				int intvalue = Integer.parseInt(value);
				Constants.TIME = intvalue;
			}
			else
			{
				throw new RuntimeException("Unknown Argument: " + name);
			}
		}
	}
}
