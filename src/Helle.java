

public class Helle extends Felt{
	double gevinst = 0;
	
	public Helle(int gevinst){
		navn = "Helle";
		this.gevinst = gevinst;
	}
	
	public void landet(Spiller sp){ // overskriver metode i Felt
		sp.besked("Du er landet på helle og får overført "+gevinst);
		sp.transaktion(gevinst);
	}
}
