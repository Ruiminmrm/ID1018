import java.util.*;    // Scanner
import static java.lang.System.out;

class Ou4OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in tv� naturliga heltal
		Scanner    in = new Scanner (System.in);
		out.println ("tv� naturliga heltal:");
		String    tal1 = in.next ();
		String    tal2 = in.next ();
		out.println ();

		// addera heltalenoch visa resultatet
		String    summa= addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');


		// subtrahera heltalen och visa resultatet
		//koden h�r
		String    differens= subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');
	}
	// addera tar emot tv� naturliga heltal givna somteckenstr�ngar, och returnerar deras
	// summa somen teckenstr�ng.
	public static String addera (String tal1 , String tal2)
	{
		// koden ska skrivas h�r
		StringBuilder svar = new StringBuilder ();
		int    siffra1 = 0;
		int    siffra2 = 0;
		int    carry = 0;
		int    rest = 0;
		int    pos1 = tal1.length() - 1;
		int    pos2 = tal2.length() - 1;

		while(pos1 >= 0 && pos2 >= 0)//n�r tal1 och tal2 har siffor p� samma position
		{
			siffra1 = tal1.charAt(pos1) - '0';//siffra1 i unicode form
			siffra2 = tal2.charAt(pos2) - '0';//siffra2 i unicode form
			rest = ( carry +siffra1 + siffra2) % 10;
			carry = (carry + siffra1 + siffra2) / 10;
			svar.insert(0, rest);
			pos1--;//r�kna fr�n h�ger till v�nster ,vilket betyder att fr�n h�gsta position till l�gre position.
			pos2--;
		}
		while (pos1 >= 0)//n�r tal1 har sifforna p� vissa positionerna som tal2 har inte siffor p�
		{
			siffra1 = tal1.charAt(pos1) - '0';
			rest = (carry + siffra1) % 10;
			carry = (carry + siffra1) / 10;
			svar.insert(0,rest);
			pos1--;

		}
		while (pos2 >= 0)//n�r tal2 har sifforna p� vissa positionerna som tal1 har inte siffor p�
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

	// subtrahera tar emot tv� naturliga heltal givna somteckenstr�ngar, och returnerar
	// deras differens somen teckenstr�ng.
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.

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
	// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation
	// utf�rd i samband med hetalen
	public static void visa (String tal1, String tal2,String resultat, char operator)
	{
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
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
	// sattLen l�gger till ett angivet antal mellanslagi b�rjan av en given str�ng
	public static String sattLen (String s, int antal)
	{
		StringBuilder    sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert (0, " ");

		return sb.toString ();
	}
}