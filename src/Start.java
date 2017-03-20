

public class Start extends Felt{
	double gevinst = 0;
	
	public Start(double gevinst){
		navn = "Start";
		this.gevinst = gevinst;
	}
	
	public void passeret(Spiller sp){
		sp.besked("Du passerer start og modtager "+gevinst);
		sp.transaktion(gevinst);
	}
	
	public void landet(Spiller sp){
		sp.besked("Du lander på start og modtager "+gevinst);
		sp.transaktion(gevinst);
	}

}
