import java.util.*;    // Scanner
class Eu1upp5
{
	public static int min (int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		int Min = element[0];//antar den f�sta element �r den minsta
		for (int i = 0 ; i <= element.length -1; i++)//skapa ett loop f�r att leta efter minsta element
		{
			if (element[i]<Min)
				Min = element [i];
	    }
		System.out.println (java.util.Arrays.toString (element));
		return Min;
     }
}