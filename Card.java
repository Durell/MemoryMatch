class Card
{
	private int num;
	private boolean show;

	public Card()
	{
		num = 0;
		show = false;
	}

	public Card(int i)
	{
		num = i;
		show = false;
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int i)
	{
		this.num = i;
	}

	public boolean getShow()
	{
		return show;
	}

	public void setShow(boolean s)
	{
		this.show = s;
	}

	public String displayCard()
	{
		if (show)
			return ("" + this.num);
		else
			return "*";
	}

	public boolean equals(Card c)
	{
		return (this.num == c.num);
	}

	public String toString()
	{
		return ("Card Number: " + this.num
				 + "; Showing: " + this.show + ". ");
	}

}