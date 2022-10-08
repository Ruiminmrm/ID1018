import java.util.Scanner;
class Ou3BestamDenKortasteVagen
{
	public static void main (String[]args)
	{
		Scanner in = new Scanner (System.in);
		//ange antalet station i Z2 och Z3
		System.out.println("antalet stationer i zon 2: ");
		int antalstationiZ2 = in.nextInt();
		System.out.println("antalet stationer i zon 3: ");
		int antalstationiZ3 = in.nextInt();

		//skapa plats att lagra langden
		double[]    a= new double[antalstationiZ2];
		double[][]    b=new double[antalstationiZ2][antalstationiZ3];
		double[]    c= new double[antalstationiZ3];

		//mata in langden
		//mata in langden mellan Z1 och Z2
		System.out.println("längden mellan z1 och z2");
		for (int i=0 ; i < antalstationiZ2 ; i++ )
			a[i]=in.nextDouble();
		System.out.println ();
		//mata in langden mellan Z2 och Z3
		System.out.println("längden mellan z2 och z3");
		for (int i=0 ; i < antalstationiZ2 ; i++ )
			{
				for(int j=0 ; j < antalstationiZ3 ; j++ )
					b[i][j]=in.nextDouble();
			}
		System.out.println ();
		//mata in langden mellan Z3 och Z4
		System.out.println("längden mellan z3 och z4");
		for(int j=0 ; j < antalstationiZ3 ; j++ )
			c[j]=in.nextDouble();
		System.out.println ();

		//mij
		int[] mellanstation=new int[0];
		mellanstation = Ou3DenKortasteVagen.mellanstationer(a,b,c);
		System.out.println("den kostaste vägen genom station : ["+mellanstation[1]+","+mellanstation[2]+"]");
		//kortaste avstånd
		double dMin = Ou3DenKortasteVagen.langd(a,b,c);
		System.out.println("kortaste avståndet= "+dMin);
	}
}