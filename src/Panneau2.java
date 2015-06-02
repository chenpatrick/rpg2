import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau2 extends JPanel {

	int size = 2;
	int size2 = 2;
	// Boutons de departs
	String[][] boutons = new String[size][size2];
	boolean[][] bool = new boolean[size][size2];
	Color couleur = new Color(1, 49, 180);
	int x = 0;
	int y = 0;

	String pero = "Pavel";

	public Panneau2() {
		// On commence avec Pavel
		boutons[0][0] = "Sword Attack";
		boutons[0][1] = "Spiral storm";
		boutons[1][0] = "Do nothing";
		boutons[1][1] = "?";

	}

	public void perso(int perso) {
		if (perso == 0) {
			boutons[0][0] = "Sword Attack";
			boutons[0][1] = "Spiral storm";
			boutons[1][0] = "Do nothing";
			boutons[1][1] = "?";
			couleur = Color.BLUE;
			pero = "pavel";
		} else if (perso == 1) {
			boutons[0][0] = "Angel fall";
			boutons[0][1] = "Fire wings";
			boutons[1][0] = "Fair";
			boutons[1][1] = "?";
			couleur = new Color(102, 0, 255);
			pero = "Cyntia";
		} else if (perso == 2) {
			boutons[0][0] = "cure";
			boutons[0][1] = "Verry Cure";
			boutons[1][0] = "Do nothing";
			boutons[1][1] = "?";
			couleur = new Color(253, 108, 158);
			pero = "Sophia";
		}
	}

	public void update() {
		boutons = new String[size][size2];
		bool = new boolean[size][size2];
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		for (int i = 0; i < boutons.length; i++) {
			for (int j = 0; j < boutons[0].length; j++) {
				g.setColor(Color.black);
				g.fillRect(x, y, (int) (290 / boutons[0].length),
						(int) (200 / boutons.length));

				g.setColor(couleur);
				g.fillRect(x, y, (int) (290 / boutons[0].length) - 1,
						(int) (200 / boutons.length) - 1);

				if (bool[i][j]) {
					g.setColor(new Color(199, 208, 204));
					g.fillRect(x, y, (int) (290 / boutons[0].length) - 1,
							(int) (200 / boutons.length) - 1);
				}
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial", Font.BOLD, 17));
				g.drawString(boutons[i][j] + "", x, y + 60);
				g.setColor(couleur);
				g.drawString(pero, 100, 350);
				x = x + (int) (290 / boutons[0].length);
			}
			x = 0;
			y = y + (int) (200 / boutons.length);
		}

		x = y = 0;
	}

}
