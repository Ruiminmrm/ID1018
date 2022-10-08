import java.io.*; // PrintWriter
import java.util.*;//
class Ou5polylinjetest
{
	public static void main (String [] args)
	{
		PrintWriter out = new PrintWriter (System.out, true);

        // skapa
		Punkt    p0 = new Punkt ("A", 1 , 2);
		Punkt    p1 = new Punkt ("B", 2 , 2);
		Punkt    p2 = new Punkt ("C", 3 , 5);
		Punkt    p3 = new Punkt ("D", 4 , 5);
		Punkt[]    p = {p0,p1,p2,p3};
		Polylinje    poly = new Polylinje(p);
        out.println( poly );
        out.println();

        // testa get
        out.println("Testa get:");
		Punkt[]    horn = poly.getHorn();
		String    farg = poly.getFarg();
		int    bredd = poly.getBredd();
        out.println( Arrays.toString(horn)+ "\n" + farg + "\n" + bredd );
        out.println();

        // testa set
        out.println("Testa set:");
        poly.setFarg(" Red ");
        poly.setBredd( 2 );
        out.println( poly );
        out.println();

        //testa langd
        out.println("Testa langd:");
        out.println( poly.langd() );
        out.println();

        //testa att lägg till en vektor
        out.println("Testa att lagg till en vektor:");
        Punkt    p4 = new Punkt ( "E",5,6);
        poly.laggTill(p4);
        out.println( poly );
        out.println();

        //testa att lägg till en vektor framför
        out.println("Testa att lagg till en vektor F framfor B:");
        Punkt    p5 = new Punkt ("F",2,6);
        poly.laggTillFramfor(p5,"B");
        out.println( poly );
        out.println();

        //testa ta bort
        out.println("Testa att ta bort vektorn C : ");
        poly.taBort("B");
        out.println( poly );
        out.println();

        //PolylinjeIterator
        Polylinje.PolylinjeIterator iterator = poly.new PolylinjeIterator();
        while ( iterator.finnsHorn())
       // for (int i = 0; i < poly.getHorn().length ;i++)
		{
			Punkt hornIterator = iterator.horn();
			out.println(hornIterator);
			iterator.gaFram();
		}
	}
}
