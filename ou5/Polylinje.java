class  Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}
	public String toString ()
	{
		String s = " ";
		for (int i = 0; i < horn.length; i++)
			s += this.horn[i];
		return    "{[" + s +" ," + farg+" ," + bredd + "]}";
	}

	public Punkt[] getHorn ()//skapa en nya plats och kopia alla punkter och returnera referens
	{
		Punkt[]    h = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			h[i] = new Punkt (horn[i]);

		return    h;
	}

	public String getFarg ()
	{
		return    this.farg;
	}

	public int getBredd ()
	{
		return    this.bredd;
	}

	public void setFarg (String farg)
    {
		this.farg = farg;
	}

	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	public double langd ()
	{
		double d = 0;
		for (int i = 0; i < this.horn.length-1; i++)
		    d += this.horn[i].avstand (this.horn[i+1]);
		return    d;
	}

    public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt (horn);

		this.horn = h;
	}

	public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		//best�ma position f�r den ny h�rn
		int pos = 0;
		while ( pos < this.horn.length && (!this.horn[pos].getNamn().equals(hornNamn)))
		      pos++;
		//om det inte finns det h�rnet med givna namnet
		if (!(pos < this.horn.length))
		    return;
		//l�gg till det givna h�rnrt p� r�tt  plats
		Punkt[]    h = new Punkt [this.horn.length + 1];//skapa en ny array f�r att referera
		int     i = 0;
		while (i < pos)//kopia alla adress som framf�r h�rnet
		{
			h[i] = this.horn[i];
			i++;
		}
		h[i] = new Punkt(horn);//kopia nya h�rnet
		while ( i < this.horn.length)//s�tt  h�rnet
		{
			h[i+1] = this.horn[i];
			i++;
		}
		this.horn = h;
	}

    public void taBort (String hornNamn)
    {
		//best�me position f�r det h�rn som har det givna namnet
		int    pos = 0;
		while (pos < this.horn.length && (!this.horn[pos].getNamn().equals(hornNamn)))
		    pos++;
		//om h�rnet med givna namnet inte finns
		if (!(pos < this.horn.length))
		    return;
		//ta bort h�rnet
		Punkt[]    h = new Punkt [this.horn.length - 1];//skapa en mindre array
		int    i = 0;
		while(i < pos)//kopia allt framf�r den h�rnet som ska f�rsvinna
		{
			h[i] = this.horn[i];
			i++;
	    }
		i = pos + 1;
		while (i < this.horn.length)//kopia allt efter den h�rnet som ska f�rsvinna
		{
			h[i-1] = this.horn[i];
			i++;
		}
		this.horn = h;
	}
	public class PolylinjeIterator
	{
		 private int aktuell = -1;
		 public PolylinjeIterator ()
		 {
			 if (Polylinje.this.horn.length > 0)
				 aktuell = 0;
	     }
		 public boolean finnsHorn ()
		 {
			 return aktuell != -1;
		 }
		 public Punkt horn () throws java.util.NoSuchElementException
		 {
			 if (!this.finnsHorn ())
				 throw new java.util.NoSuchElementException ( "slut av iterationen");
				 Punkt horn = Polylinje.this.horn[aktuell];
				 return horn;
		 }
		 public void gaFram ()
		 {
			 if (aktuell >= 0 &&
			 	 aktuell < Polylinje.this.horn.length - 1)
			 	 aktuell++;
			 else
				 aktuell = -1;
		}
	}
}