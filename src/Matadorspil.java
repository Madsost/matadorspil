import java.util.*;

public class Matadorspil {
	ArrayList<Felt> felter = new ArrayList<>();
	ArrayList<Spiller> spillere = new ArrayList<>();
	int spillersTur = 0;

	public Matadorspil() {
		felter.add(new Start(5000));
		felter.add(new Gade("R�dovrevej", 10000, 400, 1000));
		felter.add(new Gade("Hvidovrevej", 10000, 400, 1000));
		felter.add(new Rederi("Maersk", 17000, 4200));
		felter.add(new Gade("Gade 3", 12000, 500, 1200));
		felter.add(new Gade("Gade 4", 12000, 500, 1200));
		felter.add(new Bryggeri("Tuborg", 17000, 200));
		felter.add(new Gade("Gade 5", 15000, 700, 1500));
		felter.add(new Helle(15000));
		felter.add(new Gade("Frederiksberg All�", 20000, 1100, 2000));
		felter.add(new Gade("R�dhuspladsen", 20000, 1100, 2000));
	}

	public void flyt() {
		Spiller sp = this.spillere.get(this.spillersTur % this.spillere.size());
		sp.aktiv = true;
		sp.slag = (int) (Math.random() * 6) + 1;

		// System.out.println("****** "+sp.navn+" p� felt "+sp.feltnr+" sl�r
		// "+sp.slag);

		for (int i = 1; i <= sp.slag; i++) // nu rykkes der
		{
			// g� til n�ste felt. Hvis vi n�r over antal felter, s� t�l fra nul
			sp.feltnr = (sp.feltnr + 1) % this.felter.size();
			Felt felt = this.felter.get(sp.feltnr);

			if (i < sp.slag)
				felt.passeret(sp);
			else
				felt.landet(sp);
		}
		spillersTur++;
	}

}
