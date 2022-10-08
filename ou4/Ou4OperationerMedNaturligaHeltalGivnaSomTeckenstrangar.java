import java.util.*;    // Scanner
import static java.lang.System.out;

class Ou4OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in två naturliga heltal
		Scanner    in = new Scanner (System.in);
		out.println ("två naturliga heltal:");
		String    tal1 = in.next ();
		String    tal2 = in.next ();
		out.println ();

		// addera heltalenoch visa resultatet
		String    summa= addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');


		// subtrahera heltalen och visa resultatet
		//koden här
		String    differens= subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');
	}
	// addera tar emot två naturliga heltal givna somteckensträngar, och returnerar deras
	// summa somen teckensträng.
	public static String addera (String tal1 , String tal2)
	{
		// koden ska skrivas här
		StringBuilder svar = new StringBuilder ();
		int    siffra1 = 0;
		int    siffra2 = 0;
		int    carry = 0;
		int    rest = 0;
		int    pos1 = tal1.length() - 1;
		int    pos2 = tal2.length() - 1;

		while(pos1 >= 0 && pos2 >= 0)//när tal1 och tal2 har siffor på samma position
		{
			siffra1 = tal1.charAt(pos1) - '0';//siffra1 i unicode form
			siffra2 = tal2.charAt(pos2) - '0';//siffra2 i unicode form
			rest = ( carry +siffra1 + siffra2) % 10;
			carry = (carry + siffra1 + siffra2) / 10;
			svar.insert(0, rest);
			pos1--;//räkna från höger till vänster ,vilket betyder att från högsta position till lägre position.
			pos2--;
		}
		while (pos1 >= 0)//när tal1 har sifforna på vissa positionerna som tal2 har inte siffor på
		{
			siffra1 = tal1.charAt(pos1) - '0';
			rest = (carry + siffra1) % 10;
			carry = (carry + siffra1) / 10;
			svar.insert(0,rest);
			pos1--;

		}
		while (pos2 >= 0)//när tal2 har sifforna på vissa positionerna som tal1 har inte siffor på
		{
			siffra2 = tal2.charAt(pos2) - '0';
			rest = (carry + siffra2) % 10;
			carry = (carry + siffra2) / 10;

			svar.insert(0,rest);
			pos2--;
		}
		if(carry>0)
		{
			svar.insert(0,carry) ;
	    }
		return svar.toString();
	}

	// subtrahera tar emot två naturliga heltal givna somteckensträngar, och returnerar
	// deras differens somen teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.

	public static String subtrahera (String tal1, String tal2)
	{
		StringBuilder svar = new StringBuilder ();
		int    siffra1 = 0;
		int    siffra2 = 0;
		int    lan = 0;
		int    rest = 0;
		int    pos1 = tal1.length() - 1;
		int    pos2 = tal2.length() - 1;


		while(pos1 >= 0 && pos2 >= 0)
		{
			siffra1 = tal1.charAt(pos1) - '0';//siffra1 i unicode form
			siffra2 = tal2.charAt(pos2) - '0';//siffra2 i unicode form

			if (siffra1 < siffra2)
			{
				siffra1 = siffra1+10-lan;
				rest = siffra1 - siffra2;
				lan=1;
			}
			else
			{
				rest = siffra1 - siffra2;
			}

			svar.insert(0, rest);
			pos1--;
			pos2--;
		 }

		while(pos1 >= 0)
		{
			siffra1=tal1.charAt(pos1) - '0';
			if(lan==1)
			{
				rest = siffra1-lan;
				lan=0;
			}
			else
			{
				rest = siffra1;
			}
			svar.insert(0, rest);
			pos1--;
		}


		return svar.toString();
	}
	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
	// utförd i samband med hetalen
	public static void visa (String tal1, String tal2,String resultat, char operator)
	{
		// sätt en lämplig längd på heltalen och resultatet
	    int    len1 = tal1.length ();
	    int    len2 = tal2.length ();
	    int    len  = resultat.length ();
	    int    maxLen = Math.max (Math.max (len1, len2), len);
	    tal1 = sattLen (tal1, maxLen -len1);
	    tal2 = sattLen (tal2, maxLen -len2);
	    resultat = sattLen (resultat, maxLen -len);

	    // visa heltalen och resultatet
	    out.println ("  " + tal1);
	    out.println ("" + operator + " " + tal2);
	    for (int i = 0; i < maxLen + 2; i++)
			out.print ("-");
	    out.println ();
		out.println ("  " + resultat + "\n");
	}
	// sattLen lägger till ett angivet antal mellanslagi början av en given sträng
	public static String sattLen (String s, int antal)
	{
		StringBuilder    sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert (0, " ");

		return sb.toString ();
	}
}