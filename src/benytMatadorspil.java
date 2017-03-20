public class benytMatadorspil {
	public static void main(String[] args) {
		Matadorspil spil = new Matadorspil();
		spil.spillere.add(new Spiller("Søren", 50000));
		spil.spillere.add(new Spiller("Lars", 50000));
		MatadorGrafikPanel panel = new MatadorGrafikPanel(spil);

		// løb gennem 20 runder
		/*
		 * for(spil.spillersTur=0; spil.spillersTur<40; spil.spillersTur++) { //
		 * tag skiftevis Søren og Lars spil.flyt(); panel.opdater(spil); try {
		 * Thread.sleep(3000); } catch (Exception e){} // tur slut, vent 3
		 * sekunder }
		 */
	}
}
