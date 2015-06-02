import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	/**
	 * gestion dela map
	 */
	int map = 0;
	int map2 = 0;
	int size = 500;
	int size2 = 700;

	// gestion des PV
	ArrayList<Integer> PV = new ArrayList<Integer>();
	// Gestion de PP Magie
	ArrayList<Integer> PP = new ArrayList<Integer>();
	// Nom des creatures
	ArrayList<String> NAME = new ArrayList<String>();

	// Liste contenant les PV des ennemies pour l'instant mettons ceci: on ne
	// vois pas ses pv dans l'ecran
	ArrayList<Integer> PV2 = new ArrayList<Integer>();

	int numerojoueur = 0;

	int x = 300;
	int y = 380;
	int x2 = 340;
	int y2 = 380;
	int x3 = 380;
	int y3 = 380;
	int orientation = 0;
	int avance = 1;
	int orientation2 = 0;
	int avance2 = 1;
	int orientation3 = 0;
	int avance3 = 1;
	// ennemy
	int[] tx = { 120, 50 };
	int[] ty = { 380, 360 };
	int[] avancem = { 1, 1 };
	int cursor = 120;

	// level = map : mode = rpg ou action
	int level = 0;
	boolean mode = true;

	public void paint(Graphics g) {
		if (!mode) {
			if (level == 0) {
				/*
				 * ImageIcon imageIcon = new ImageIcon(
				 * "image/Map/BattleMap-CrystalCastle.gif");
				 */

				ImageIcon imageIcon = new ImageIcon("image/Map/home/home.gif");

				Image w = imageIcon.getImage();
				g.drawImage(w, map, map2, size, size2, this);
			}

			if (orientation == 0) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon("img/d1.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);
					// g.drawImage(w,x,y,this);
					break;

				case 2:

					ImageIcon image = new ImageIcon("img/d2.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon("img/d3.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon("img/d4.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;
				}
			}
			if (orientation == 1) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon("img/l4.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);
					// g.drawImage(w,x,y,this);
					break;

				case 2:

					ImageIcon image = new ImageIcon("img/l3.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon("img/l2.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon("img/l1.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;
				}
			}

			if (orientation == 2) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon("img/b1.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);
					// g.drawImage(w,x,y,this);
					break;

				case 2:

					ImageIcon image = new ImageIcon("img/b2.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon("img/b3.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon("img/b4.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;
				}
			}
			if (orientation == 3) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon("img/h1.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);
					// g.drawImage(w,x,y,this);
					break;

				case 2:

					ImageIcon image = new ImageIcon("img/h2.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon("img/h3.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon("img/h4.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;
				}
			}
			// Tourner

			if (orientation == 4) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon("img/e2.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);
					// g.drawImage(w,x,y,this);
					break;

				case 2:

					ImageIcon image = new ImageIcon("img/e3.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon("img/e4.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon("img/e5.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;

				case 5:

					ImageIcon image5 = new ImageIcon("img/ed4.gif");
					Image d5 = image5.getImage();

					g.drawImage(d5, x, y, this);
					break;

				case 6:

					ImageIcon image6 = new ImageIcon("img/ed3.gif");
					Image d6 = image6.getImage();

					g.drawImage(d6, x, y, this);
					break;

				case 7:

					ImageIcon image7 = new ImageIcon("img/ed2.gif");
					Image d7 = image7.getImage();

					g.drawImage(d7, x, y, this);
					break;

				case 8:

					ImageIcon image8 = new ImageIcon("img/eh1.gif");
					Image d8 = image8.getImage();

					g.drawImage(d8, x, y, this);
					break;

				case 9:

					ImageIcon image9 = new ImageIcon("img/eh2.gif");
					Image d9 = image9.getImage();

					g.drawImage(d9, x, y, this);
					break;

				case 10:

					ImageIcon image10 = new ImageIcon("img/eh3.gif");
					Image d10 = image10.getImage();

					g.drawImage(d10, x, y, this);
					break;
				case 11:

					ImageIcon image11 = new ImageIcon("img/eh4.gif");
					Image d11 = image11.getImage();

					g.drawImage(d11, x, y, this);
					break;
				case 12:

					ImageIcon image12 = new ImageIcon("img/eh5.gif");
					Image d12 = image12.getImage();

					g.drawImage(d12, x, y, this);
					break;
				case 13:

					ImageIcon image13 = new ImageIcon("img/eg2.gif");
					Image d13 = image13.getImage();

					g.drawImage(d13, x, y, this);
					break;
				case 14:

					ImageIcon image14 = new ImageIcon("img/eg3.gif");
					Image d14 = image14.getImage();

					g.drawImage(d14, x, y, this);
					break;
				case 15:

					ImageIcon image1a = new ImageIcon("img/eg4.gif");
					Image d1a = image1a.getImage();

					g.drawImage(d1a, x, y, this);
					break;
				case 16:

					ImageIcon image16 = new ImageIcon("img/eg5.gif");
					Image d16 = image16.getImage();

					g.drawImage(d16, x, y, this);
					break;
				}
			}

		} else {
			if (level == 0) {

				ImageIcon imageIcon = new ImageIcon("image/Map/map.png");
				Image w = imageIcon.getImage();
				g.drawImage(w, map, map2, size, size2, this);

				if (magikp) {

					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 1000, 1000);
					/*
					 * int var = 10; int var2 = 10; for (int j = 0; j < 2; j++)
					 * { for (int i = 0; i < 12; i++) { g.setColor(Color.WHITE);
					 * g.fillOval(var, var2, 10, 10); var += 30; } var = 10;
					 * var2 = +50; }
					 */
					int x0 = 500 / 2;
					int y0 = 500 / 2;
					int x, y;
					double a, b;
					a = 0.7;
					b = 0.7;
					g.setColor(Color.WHITE);
					for (int teta = 0; teta < 180 * 3; teta += 5) {
						x = (int) (x0 + (a * teta)
								* Math.cos((Math.PI * teta * b) / 180));
						y = (int) (y0 + (a * teta)
								* Math.sin((Math.PI * teta * b) / 180));
						g.fillOval(x, y, 10, 10);
					}
				}
				if (magikc) {
					g.setColor(new Color(219, 23, 2));
					g.fillRect(0, 0, 1000, 1000);
					int x0 = 500 / 2;
					int y0 = 500 / 2;
					int x, y;
					double a, b;
					a = 0.7;
					b = 30.7;
					g.setColor(Color.GREEN);
					for (int teta = 0; teta < 180 * 3; teta += 5) {
						x = (int) (x0 + (a * teta)
								* Math.cos((Math.PI * teta * b) / 180));
						y = (int) (y0 + (a * teta)
								* Math.sin((Math.PI * teta * b) / 180));
						g.fillOval(x, y, 10, 10);
					}
				}
				if (magikw) {
					int x, y;

					g.setColor(Color.PINK);
					g.fillRect(0, 0, 1000, 1000);
					g.setColor(Color.WHITE);
					for (int i = 0; i < 100; i++) {
						x = (int) (Math.random() * 500);
						y = (int) (Math.random() * 500);
						g.fillOval(x, y, 10, 10);
					}
				}
				if (magikM) {
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 1000, 1000);
					g.setColor(Color.BLUE);
					dragon2(i, 249, 249, 100, 100, g);
				}

				// Affichage des PVs
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial", Font.BOLD, 17));
				for (int ii = 0, i = 200; (ii < PV.size() && i < 500); ii++, i += 100) {
					g.drawString(NAME.get(ii) + "", i, 40);
					g.setColor(Color.RED);
					g.drawString("PV : " + PV.get(ii) + "", i, 70);
					g.setColor(Color.WHITE);
					g.drawString("PP : " + PP.get(ii) + "", i, 90);
				}
				for (int ii = 0, i = 20; (ii < PV2.size() && i < 300); ii++, i += 100) {
					
					g.setColor(Color.ORANGE);
					g.drawString("PV : " + PV2.get(ii) + "", i, 140);
				
				}

			}
			// Les personnages AnimiX
			// Attack PAVEL

			if (orientation == 0) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/pavel/ppose.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/pavel/pm.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/pavel/pm2.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon(
							"image/Personnage/pavel/pm3.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x, y, this);

					break;
				case 5:

					ImageIcon imag43 = new ImageIcon(
							"image/Personnage/pavel/pattack.gif");
					Image d4 = imag43.getImage();
					ImageIcon imag4 = new ImageIcon(
							"image/Personnage/pavel/psword.gif");
					Image d44 = imag4.getImage();

					g.drawImage(d4, x, y, this);

					g.drawImage(d44, x - 40, y - 50, this);

					break;
				case 6:

					ImageIcon image1 = new ImageIcon(
							"image/Personnage/pavel/pm3.gif");
					Image dd = image1.getImage();

					g.drawImage(dd, x, y, this);

					break;

				}
			}
			// magie
			if (orientation == 1) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/pavel/pspell2.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/pavel/pspell3.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/pavel/pspell.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;
				}
			}
			if (orientation == 2) {
				switch (avance) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/pavel/phurt.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x, y, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/pavel/phurt2.gif");
					Image d = image.getImage();

					g.drawImage(d, x, y, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/pavel/phurt3.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x, y, this);

					break;
				}
			}
			// Cyntia

			if (orientation2 == 0) {
				switch (avance2) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/elf/estand.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x2, y2, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/elf/estand2.gif");
					Image d = image.getImage();

					g.drawImage(d, x2, y2, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/elf/eback.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x2, y2, this);

					break;
				}
			}
			if (orientation2 == 1) {
				switch (avance2) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/elf/ehurt.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x2, y2, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/elf/ehurt2.gif");
					Image d = image.getImage();

					g.drawImage(d, x2, y2, this);
					break;
				}
			}
			if (orientation2 == 2) {
				switch (avance2) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/elf/emagik.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x2, y2, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/elf/emagik2.gif");
					Image d = image.getImage();

					g.drawImage(d, x2, y2, this);
					break;
				}
			}
			if (orientation2 == 3) {
				switch (avance2) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/elf/efly.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x2, y2, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/elf/efly2.gif");
					Image d = image.getImage();

					g.drawImage(d, x2, y2, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/elf/efleche.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x2, y2, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon(
							"image/Personnage/elf/efleche2.gif");
					Image d2 = image3.getImage();
					ImageIcon image33 = new ImageIcon(
							"image/Personnage/elf/earc2.gif");
					Image d23 = image33.getImage();
					g.drawImage(d2, x2, y2, this);
					g.drawImage(d23, x2 - 70, y2 + 70, this);
					break;
				}
			}

			// Girl witch
			if (orientation3 == 0) {
				switch (avance3) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/sorcier/sstand.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x3, y3, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/sorcier/sinjure.gif");
					Image d = image.getImage();

					g.drawImage(d, x3, y3, this);
					break;

				case 3:

					ImageIcon image2 = new ImageIcon(
							"image/Personnage/sorcier/sspell.gif");
					Image d1 = image2.getImage();

					g.drawImage(d1, x3, y3, this);

					break;

				case 4:

					ImageIcon image3 = new ImageIcon(
							"image/Personnage/sorcier/sspell2.gif");
					Image d2 = image3.getImage();

					g.drawImage(d2, x3, y3, this);

					break;
				}
			}

			if (orientation3 == 1) {
				switch (avance3) {
				case 1:

					ImageIcon imageIcon = new ImageIcon(
							"image/Personnage/sorcier/shurt.gif");
					Image w = imageIcon.getImage();

					g.drawImage(w, x3, y3, this);

					break;

				case 2:

					ImageIcon image = new ImageIcon(
							"image/Personnage/sorcier/smort.gif");
					Image d = image.getImage();

					g.drawImage(d, x3, y3, this);
					break;
				}
			}

			switch (avancem[0]) {
			case 1:

				ImageIcon imageIcon = new ImageIcon(
						"image/Personnage/mechant/g1.png");
				Image w = imageIcon.getImage();

				g.drawImage(w, tx[0], ty[0], this);

				break;

			case 2:

				ImageIcon image = new ImageIcon(
						"image/Personnage/mechant/gpoing.png");
				Image d = image.getImage();

				g.drawImage(d, tx[0], ty[0], this);
				break;

			case 3:

				ImageIcon image2 = new ImageIcon(
						"image/Personnage/mechant/g3.png");
				Image d1 = image2.getImage();

				g.drawImage(d1, tx[0], ty[0], this);

				break;

			case 4:

				ImageIcon image3 = new ImageIcon(
						"image/Personnage/mechant/g4.png");
				Image d2 = image3.getImage();

				g.drawImage(d2, tx[0], ty[0], this);

				break;
			case 5:

				ImageIcon imag4 = new ImageIcon(
						"image/Personnage/mechant/g5.png");
				Image d44 = imag4.getImage();
				g.drawImage(d44, tx[0], ty[0], this);

				break;
			case 6:

				ImageIcon image1 = new ImageIcon(
						"image/Personnage/mechant/gattack.png");
				Image dd = image1.getImage();
				ImageIcon imag2 = new ImageIcon(
						"image/Personnage/mechant/gboule.png");
				Image dd2 = imag2.getImage();
				g.drawImage(dd, tx[0], ty[0], this);
				g.drawImage(dd2, tx[0] + 100, ty[0], this);
				break;

			}

		}
		switch (avancem[1]) {
		case 1:

			ImageIcon imageIcon = new ImageIcon(
					"image/Personnage/mechant/m1.gif");
			Image w = imageIcon.getImage();

			g.drawImage(w, tx[1], ty[1], this);

			break;

		case 2:

			ImageIcon image = new ImageIcon("image/Personnage/mechant/m2.gif");
			Image d = image.getImage();

			g.drawImage(d, tx[1], ty[1], this);
			break;
		case 3:

			ImageIcon image2 = new ImageIcon("image/Personnage/mechant/m3.gif");
			Image d1 = image2.getImage();

			g.drawImage(d1, tx[1], ty[1], this);

			break;

		case 4:

			ImageIcon image3 = new ImageIcon("image/Personnage/mechant/m4.gif");
			Image d2 = image3.getImage();

			g.drawImage(d2, tx[1], ty[1], this);

			break;
		}

		g.setColor(Color.BLUE);
		g.fillOval(cursor, 300, 20, 20);

	}

	boolean magikp = false;
	boolean magikc = false;
	boolean magikw = false;
	boolean magikM = false;
	int i = 1;

	// Fonction subsidiaire
	static void dragon(int n, int x, int y, int z, int t, Graphics g) {
		int u, v;
		if (n == 1) {
			g.drawLine(x, y, z, t);

		} else {
			u = (x + z + t - y) / 2;
			v = (y + t - z + x) / 2;
			dragon(n - 1, x, y, u, v, g);
			dragon(n - 1, z, t, u, v, g);

		}

	}

	static void dragon2(int n, int x, int y, int z, int t, Graphics g) {

		int u, v;
		if (n == 1) {
			g.drawLine(x, y, z, t);

		} else {
			u = (x + z + t - y) / 2;
			v = (y + t - z + x) / 2;
			dragon2(n - 1, x, y, u, v, g);
			dragon3(n - 1, u, v, z, t, g);

		}
	}

	/*
	 * Fonction recursif
	 */

	static void dragon3(int n, int x, int y, int z, int t, Graphics g) {
		int u, v;
		if (n == 1) {
			g.drawLine(x, y, z, t);

		} else {
			u = (x + z - t + y) / 2;
			v = (y + t + z - x) / 2;
			dragon2(n - 1, x, y, u, v, g);
			dragon3(n - 1, u, v, z, t, g);
		}
	}

}
