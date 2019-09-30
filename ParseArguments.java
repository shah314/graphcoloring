
public class ParseArguments {

	public static void parse(String [] args)
	{
		for(int i=2; i<args.length; i++)
		{
			String argument = args[i].trim();
			String [] split = argument.split("\\=");
			String name = split[0];
			String value = split[1];
			int intvalue = Integer.parseInt(value);
			if(name.equals("LOCAL_SEARCH_ITERATIONS"))
			{
				Constants.LOCAL_SEARCH_ITERATIONS = intvalue;
			}
			else if(name.equals("LOCAL_SEARCH_MAX_TIME"))
			{
				Constants.LOCAL_SEARCH_MAX_TIME = intvalue;
			}
			else if(name.equals("ITERATED_GREEDY_ITERATIONS"))
			{
				Constants.ITERATED_GREEDY_ITERATIONS = intvalue;
			}
			else if(name.equals("LOCAL_SEARCH"))
			{
				Constants.LOCAL_SEARCH = Boolean.parseBoolean(value);
			}
			else if(name.equals("TIME"))
			{
				Constants.TIME = intvalue;
			}
		}
	}
}
