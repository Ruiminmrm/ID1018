class Punkt
{
	private String    namn;
	private int    x;
	private int    y;

	public Punkt(String namn,int x,int y)
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}
	public Punkt(Punkt p)
	{
		this.namn = p.namn;
		this.x = p.x;
		this.y = p.y;
	}

	// tom punkt("",0,0)
	public Punkt()
	{
		this.namn="";
		this.x=0;
		this.y=0;
	}

	//get
	public String getNamn()
	{
		return this.namn;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}

	//prtint i (A 1 3) form
	public String toString()
	{
		return "(" + this.namn+" "+this.x + " "+this.y+")" ;
	}

	//avstand
	public double avstand(Punkt p)
	{
		return Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
	}

    //samma punkt
    public boolean equals(Punkt p)
    {
		boolean equal;
		if (this.x == p.x && this.y==p.y)
            equal = true;
		else
		    equal = false;
		return equal;
	}

	//set
    public void setNamn(String namn)
   	{
   		this.namn=namn;
	}
    public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
}