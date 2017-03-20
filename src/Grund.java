import java.awt.Color;
import java.awt.Graphics;

public class Grund extends Felt{
	Spiller ejer = null;
	double pris = 0;
	double grundleje = 0;
	boolean hus = false;
	
	public Grund(String navn, double pris, double leje)
	{
		this.navn = navn;
		this.pris = pris;
		this.grundleje = leje;
	}
	
	public double beregnLeje(Spiller sp)
	{
		return grundleje;
	}
	
	public void landet(Spiller sp)
	{
		sp.besked("Du er landet på "+navn);
		if (sp==ejer)
		{
			sp.besked("Det er din egen grund");
			hus = true;
		}
		else if (ejer==null)
		{
			if (sp.konto>pris)
			{
				if(sp.spørgsmål("købe "+navn+" for "+pris))
				{
					sp.transaktion(-pris);
					ejer=sp;
					hus = false;
				}
			}
			else sp.besked("Du har ikke penge nok til at købe "+navn);
		}
		else
		{
			double leje = beregnLeje(sp);
			sp.besked("Leje: "+leje);
			sp.betal(ejer, leje);
			hus = false;
		}
	}
	
	public void tegn(Graphics g, int x, int y){
		super.tegn(g, x, y);
		g.setColor(Color.black);
		if(ejer != null) g.drawString("Ejer: "+ejer.navn, x, y+15);
	}
}
