import java.util.*;    // Scanner
class Eu1main
{
	public static void main (String[]args)
	{
		//fråga 1 och fråga4
		Scanner in = new Scanner (System.in);
		Random Random = new Random ();
		System.out.println("antal talet:");
		int element=in.nextInt();
		int[] arry=new int[element];

		System.out.println("mata in alla tal");
		for (int i = 0; i <element;i++)
		{
			 arry[i]= Random.nextInt(100);
		}
		//frågan 2
		int[] arry2 = { 4,5,6,7,8,9,87,45,15,12,43,16,78,12,14,15,1,26,98};
        //anropa metoder
		int upp1 = Eu1upp1.min(arry);
		int upp2 = Eu1upp1.min(arry2);
	    int upp5 = Eu1upp4.min(arry);
        //resultat
        System.out.println();
	    System.out.println("fråga 1= "+upp1);
	    System.out.println()
		System.out.println("fråga 2= "+upp2);
		System.out.println()
		System.out.println("fråga 5= "+upp5);

}
}