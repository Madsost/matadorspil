import java.awt.Graphics;

/** Superklasse for alle matadorspillets felter */
public class Felt {
	String navn = "";
	
	/** kaldes n�r en spiller passerer dette felt */
	public void passeret(Spiller sp){
		//sp.besked("Du passerer " + navn);
	}
	
	/** kaldes n�r en spiller lander p� dette felt */
	public void landet(Spiller sp){
		
	}
	
	/**  */
	public void tegn(Graphics g, int x, int y){
		g.drawString(navn, x, y);
	}
	
}
