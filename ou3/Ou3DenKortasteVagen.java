import java.util.Scanner;
class Ou3DenKortasteVagen
{
	/* mellanstationer returnerar en vektor med de mellanstationersom finns på den kortaste
	 vägen. Ordningsnummerav den förstamellanstationen finns på index1, ochordningsnummer
	 av den andra mellanstationen på index2 i vektorn.*/
	public static int[] mellanstationer ( double[] a, double[][] b,double[] c)
	{
		int antalstationiZ2=a.length;
		int antalstationiZ3=c.length;
		double dmin=a[0]+b[0][0]+c[0];
		int[] mellanstation= new int[3];
		mellanstation[1]=1;
		mellanstation[2]=1;

		for (int i=0 ; i <antalstationiZ2 ;i++  )
		{
			for(int j=0 ; j <antalstationiZ3 ;j++ )
			{
				double langden =a[i]+b[i][j]+c[j];
				if (langden<dmin)
				{
					dmin=langden;
					mellanstation[1]= i+1;
					mellanstation[2]= j+1;
				}
			}
		}

		return mellanstation ;
	}
	public static double langd (double[] a, double[][] b, double[] c)
	{
		int antalstationiZ2=a.length;
		int antalstationiZ3=c.length;
		double dmin=a[0]+b[0][0]+c[0];
		for (int i=0 ; i < antalstationiZ2 ;i++ )
		{
			for(int j=0 ; j < antalstationiZ3 ;j++ )
			{
				double langden =a[i]+b[i][j]+c[j];
				if (langden<dmin)
				{
					dmin=langden;
				}
			}
		}
	return dmin;
   }
}