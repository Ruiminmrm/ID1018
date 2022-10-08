import java.util.*;    // Scanner
class Eu1upp5
{
	public static int min (int[] element) throws IllegalArgumentException
	{
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		int Min = element[0];//antar den fösta element är den minsta
		for (int i = 0 ; i <= element.length -1; i++)//skapa ett loop för att leta efter minsta element
		{
			if (element[i]<Min)
				Min = element [i];
	    }
		System.out.println (java.util.Arrays.toString (element));
		return Min;
     }
}