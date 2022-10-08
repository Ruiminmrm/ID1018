class Polylinje1
{
    private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	public Polylinje1 ()
	{
		this.horn = new Punkt[0];
	}

	public Polylinje1 (Punkt[] horn)
	{
		this.horn = horn;
	}
	public String toString ()
	{
		String s = " ";
		for (int i = 0; i < horn.length; i++)
			s += this.horn[i];
		return    "{[" + s +" ," + farg+" ," + bredd + "]}";
	}

	public Punkt[] getHorn ()
	{
		return    this.horn;
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
		for (int i = 0; i < horn.length; i++)
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

	public void laggTillFramfor (Punkt u, String hornNamn)
	{
        Punkt[]    h = new Punkt[this.horn.length+1];

        //best�mm position f�r det h�rn
        int    pos = 0;
        while ( pos < this.horn.length && (!this.horn[pos].getNamn().equals(hornNamn)))
            pos++;

        //l�gg till h�rnet
        h[pos] =u;

        //kopia resten av h�rnet
        for (int i=pos+1; i <= this.horn.length ; i++)
            h[i] = this.horn[i+1];

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
}