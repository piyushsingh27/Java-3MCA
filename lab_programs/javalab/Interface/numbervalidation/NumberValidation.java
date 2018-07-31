package numbervalidation;
public interface NumberValidation
{
	public static boolean numberOrNot(String input,byte flag )
    {
		try
		{
			if(1 == flag)
			Integer.parseInt(input);
			else if(2 == flag)
			Long.parseLong(input);
			else if(3 == flag)
			Float.parseFloat(input);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
    }
}
