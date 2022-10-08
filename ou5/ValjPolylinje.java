import java.io.*; // PrintWriter
import java.util.*;//
import static java.lang.System.out;
class ValjPolylinje
{
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main (String[] args)
	{
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
	    {    polylinjer[i] = slumpPolylinje ();

		     // visa polylinjerna
             out.println("Alla polylinjer: " + polylinjer[i]);
        }
		// bestäm den kortaste av de polylinjer som är gula
        Polylinje kortgul = new Polylinje();
        double minD = Double.POSITIVE_INFINITY;//antal längden är oändligt stora
        for (int i = 0;i < ANTAL_POLYLINJER; i++)
            {
				if ( polylinjer[i].getFarg().equals("yellow") && (polylinjer[i].langd() < minD))
				{
				    kortgul = polylinjer[i];
				    minD = polylinjer[i].langd();
			    }
			}
		// visa den valda polylinjen
		 out.println("Den kortaste gula linjen:  " + kortgul);
	}
	// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
	// det engelska alfabetet, och slumpmässiga koordinater.
	public static Punkt slumpPunkt ()
	{
	    String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);

		return new Punkt (n, x, y);
	}

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
	// kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte förekomma flera gånger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn)
        {
			Punkt p = slumpPunkt();
			int c = p.getNamn().charAt(0);//get namn från den position 0
            char a = 'A';
			if (valdaNamn[c - a] == false)
			{
				polylinje.laggTill(p);
				antalValdaHorn++;
				valdaNamn[c - a] = true;
			}
        }
        // sätt färg
        String[] farger = {"yellow","red","blue"};
        int i = rand.nextInt(2);
        polylinje.setFarg(farger[i]);
        return polylinje;
	}
}

