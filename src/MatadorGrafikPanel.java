import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MatadorGrafikPanel extends JPanel {
	private Dimension d;
	private Matadorspil matador;
	private Felt felt;
	private javax.swing.JTextField Besked;
	private javax.swing.JButton Klar;
	private javax.swing.JLabel slag;
	private javax.swing.JLabel spiller;

	public MatadorGrafikPanel(Matadorspil matador) {
		this.matador = matador;
		initComponents();
		JFrame vindue = new JFrame("Matadorspil");
		vindue.add(this);
		vindue.setSize(800, 640);
		vindue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vindue.setVisible(true);
		//vindue.pack();
	}

	// komponenter lavet i Netbeans
	private void initComponents() {

		Klar = new javax.swing.JButton();
		spiller = new javax.swing.JLabel();
		Besked = new javax.swing.JTextField();
		slag = new javax.swing.JLabel();

		Klar.setText("Klar!");
		Klar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				KlarActionPerformed(evt);
			}
		});

		spiller.setText("Spiller sl�r");

		Besked.setEditable(false);

		slag.setText("etTal");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(Besked, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(Klar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(spiller))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(slag)))
				.addContainerGap(188, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(198, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(spiller).addComponent(slag))
						.addGap(13, 13, 13)
						.addComponent(Besked, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(Klar)
						.addContainerGap()));
	}

	// handling n�r man trykker p� klar: udf�r en tur og opdater panelet.
	// problem: panelet opdateret EFTER spilleren har f�et stillet et sp�rgsm�l. Det skulle gerne v�re omvendt. 
	// L�ST
	// TODO: Tilf�j keylistener p� enter. 
	private void KlarActionPerformed(ActionEvent evt) {
		repaint();
		matador.flyt();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		d = getSize();
		// System.out.println("Min st�rrelse: "+d);

		int origoX = d.width / 2 - 2;
		int origoY = d.height / 2 - 2;

		int radius = 200;

		int felter = matador.felter.size();
		
		// skriver felterne p� br�ttet
		for (int i = felter; i > 0; i--) {
			felt = matador.felter.get(i - 1);
			g.setColor(Color.GRAY);
			double posX = origoX - (radius * Math.sin(2 * Math.PI * i / felter));
			double posY = origoY - (radius * Math.cos(2 * Math.PI * i / felter));
			felt.tegn(g, (int) posX, (int) posY);
		}

		// skriver spillernes saldi
		g.setColor(Color.magenta);
		int antalSpillere = matador.spillere.size();
		for (int j = antalSpillere - 1; j >= 0; j--) {
			matador.spillere.get(j).tegnStatus(g, 25, 25 + 100 * j);
		}

		// spiller-h�ndtering.
		for (Spiller sp : matador.spillere) {
			g.setColor(Color.BLUE);
			if (sp.aktiv) {		// hvis spilleren er aktiv, skriv beskeder
				spiller.setText(sp.navn + " sl�r ");
				slag.setText("" + sp.slag);
				Besked.setText(sp.besked);
				sp.aktiv = false;	// s�rg for at spilleren er inaktiv
			}
			// Tegner spillernes placering p� br�dtet
			// TODO: h�ndtering af at spillerne st�r p� samme felt mangler.
			for (int i = matador.felter.size(); i > 0; i--) {
				if (i == (sp.feltnr) + 1) {
					double posX = origoX - (radius * Math.sin(2 * Math.PI * i / felter));
					double posY = origoY - (radius * Math.cos(2 * Math.PI * i / felter));
					sp.tegn(g, (int) posX, (int) posY - 15);
				}
			}
		}

	}
}
