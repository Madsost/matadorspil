

public class Bryggeri extends Grund
{
	
	public Bryggeri(String navn, double pris, double leje)
	{
		super(navn,pris,leje);
	}
	
	public double beregnLeje(Spiller sp)
	{
		return grundleje * sp.slag;
	}
	
}
