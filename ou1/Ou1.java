import java.util.*;
class Ou1 {

	public static void main(String[] args)
		{
		System.out.println ("TEMPERATURER\n");
				// inmatningsverktyg
				Scanner    in = new Scanner (System.in);

				// mata in uppgifter om antalet veckor och antalet mätningar
				System.out.print ("antalet veckor: ");
				int    antalVeckor = in.nextInt ();
				System.out.print ("antalet mätningar per vecka: ");
				int    antalMatningarPerVecka = in.nextInt ();

				// plats att lagra temperaturer
				double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

				// mata in temperaturerna
				for (int vecka = 1; vecka <= antalVeckor; vecka++)
				{

					System.out.println ("temperaturer -vecka " + vecka+ ":");
			        for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
				        t[vecka][matning] = in.nextDouble ();
				}
				System.out.println ();

				// visa temperaturerna
				System.out.println ("temperaturerna:");
				for (int vecka = 1; vecka <= antalVeckor; vecka++)
				{
				    for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
				         System.out.print (t[vecka][matning] + " ");
				    System.out.println ();
				}
				System.out.println ();

				// den minsta,den största och medeltemperaturen–veckovis
				double[]    minT = new double[antalVeckor + 1];
				double[]    maxT = new double[antalVeckor + 1];
				double[]    sumT = new double[antalVeckor + 1];
				double[]    medelT = new double[antalVeckor + 1];
				// koden ska skrivas här

				for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//ta reda på minT
				{
                   minT[vecka] = t[vecka][1];

				   for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
					{    if (t[vecka][matning] < minT[vecka])
						     minT[vecka] = t[vecka][matning];
					}
				}
				for ( int vecka=1 ; vecka <= antalVeckor ; vecka++)//print out minT
				    System.out.print("minT["+vecka+"]="+minT[vecka]);
                System.out.println();


				for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//ta reda på maxT
				{
				     maxT[vecka] = t[vecka][1];

					 for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
					 {
						 if (t[vecka][matning] > maxT[vecka])
							 maxT[vecka] = t[vecka][matning];
					 }
				}
				for ( int vecka=1 ; vecka <= antalVeckor ; vecka++)//print out maxT
				    System.out.print("maxT["+vecka+"]="+maxT[vecka]);
                System.out.println();






                for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//ta reda på medelT
				{
					sumT[vecka]= t[vecka][1];
					for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
					{
					     sumT[vecka] = t[vecka][1]+t[vecka][matning];
					}
					medelT[vecka]=(sumT[vecka])/ (antalMatningarPerVecka);
				}
			    for ( int vecka=1 ; vecka <= antalVeckor ; vecka++)//print out medelT
				    System.out.print("medelT["+vecka+"]="+medelT[vecka]);
				System.out.println();
				System.out.println();
				System.out.println();


				// visa den minsta, den största och medeltemperaturen för varje vecka
				// koden ska skrivas här

				// den minsta, den största och medeltemperaturen -hela mätperioden
				double    minTemp = minT[1];
				double    maxTemp = maxT[1];
				double    sumTemp = sumT[1];
				double    medelTemp = 0;
				// koden ska skrivas här
				for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//minTemp
				{
				    minTemp=minT[1];
					    if (minT[vecka]<minTemp)
					        minTemp = minT[vecka];

					}
                    System.out.print("minTemp="+minTemp);
                System.out.println();




                for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//maxTemp
				{
				    maxTemp=maxT[1];
				       if (maxT[vecka]>maxTemp)
				           maxTemp = maxT[vecka];
                 }
                    System.out.print("maxTemp="+maxTemp);
                System.out.println();





                for (int vecka = 1 ; vecka <= antalVeckor ; vecka++)//medelTemp
				{
				    sumTemp=sumT[1]+sumT[vecka];
				}
				medelTemp = (sumTemp)/ (antalVeckor+antalMatningarPerVecka);
				    System.out.print("medelTemp="+medelTemp);
                System.out.println();

				// visa den minsta, den största och medeltemperaturen i hela mätperioden
				//koden ska skrivas här


	}

}
