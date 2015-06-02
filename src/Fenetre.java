import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel container = new JPanel();
	Panneau pan = new Panneau();
	Panneau2 pan2 = new Panneau2();
	JTextField jtf;
	int selection = 0;
	Thread deplacement, attack, attack2;

	// Liste des actions que nous devrons faire apprés avoir selectionné les
	// attack
	ArrayList<Integer> actionman = new ArrayList<Integer>();

	public Fenetre() {
		setTitle("Rpg");
		setSize(800, 500);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		jtf = new JTextField();

		jtf.setPreferredSize(new Dimension(0, 0));
		jtf.addKeyListener(new ClavierListener());
		JPanel south = new JPanel();
		south.add(jtf);
		container.add(south, BorderLayout.SOUTH);
		setContentPane(container);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new JScrollPane(pan), new JScrollPane(pan2));
		split.setDividerLocation(500);
		getContentPane().add(split, BorderLayout.CENTER);

		setVisible(true);
		// music("image/village.mid");
		if (pan.mode) {
			// Iitialisation
			pan.PV.add(120);
			pan.PV.add(90);
			pan.PV.add(70);
			pan.PP.add(50);
			pan.PP.add(70);
			pan.PP.add(90);
			pan.NAME.add("Pavel");
			pan.NAME.add("Cyntia");
			pan.NAME.add("Sophia");
			pan.PV2.add(100);
			pan.PV2.add(110);
			selection = pan.PV2.size() - 1;

			music("image/golden_sun_-_battle_theme.mid");

			avance();

		}
		/*
		 * movePavel(0); moveGolem(1); stand(); moveCyntia(1); moveGolem(0);
		 * movePavel(1); stand();
		 * 
		 * moveDead(2); stand(); moveWitch(0); stand();
		 * 
		 * moveCyntia(2); stand();
		 */

	}

	public void avance() {
		// Simulation mode de combat(En debut de Combat)
		if (pan.mode) {
			pan.map = -200;
			pan.size = 500 + 900;
			pan.size2 = 600;
		}
		for (int i = 0; i < 30; i++) {
			pan.map -= 20;

			pan.repaint();
			pause(100);
		}
	}

	public void pause(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void music(String s) {
		Sequencer sequencer;
		try {
			Sequence sequence = MidiSystem.getSequence(new File(s));
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(100);
			sequencer.start();

		} catch (Exception e) {
		}

	}

	class ClavierListener implements KeyListener {

		int posx = 0;
		int posy = 0;

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			/*
			 * System.out.println("Vous avez appuyé"); pan2.size ++ ;
			 * pan2.repaint();
			 */

			if (!pan.mode) {
				// Dans lemode vue de haut
				// gestion des deplacements du personnage
				if (arg0.getKeyCode() == 37) {
					pan.orientation = 1;
					pan.avance++;
					if (pan.avance == 4)
						pan.avance = 1;
					pan.x -= 20;
					pan.repaint();
				}

				if (arg0.getKeyCode() == 38) {
					pan.orientation = 3;
					pan.avance++;
					if (pan.avance == 4)
						pan.avance = 1;
					pan.y -= 20;
					pan.repaint();
				}
				if (arg0.getKeyCode() == 39) {
					pan.orientation = 0;
					pan.avance++;
					if (pan.avance == 4)
						pan.avance = 1;
					pan.x += 20;
					pan.repaint();
				}
				if (arg0.getKeyCode() == 40) {
					pan.orientation = 2;
					pan.avance++;
					if (pan.avance == 4)
						pan.avance = 1;
					pan.y += 20;
					pan.repaint();
				}

				if (arg0.getKeyCode() == 65) {
					pan.orientation = 4;
					// Later

				}
			} else {

				if (tour) {
					// deplacement du cursuer
					if (arg0.getKeyCode() == 37) {
						if (!etape) {
							if (posx - 1 >= 0) {
								pan2.bool[posy][posx] = false;
								posx -= 1;
								pan2.bool[posy][posx] = true;
								pan2.repaint();
							}
						} else {
							if (selection - 1 >= 0) {
								selection--;
								pan.cursor -= 70;
								pan.repaint();

							}

						}

					}
					if (arg0.getKeyCode() == 38) {
						if (!etape) {
							if (posy - 1 >= 0) {
								pan2.bool[posy][posx] = false;
								posy -= 1;
								pan2.bool[posy][posx] = true;
							}
						} else {

						}
						pan2.repaint();
					}
					if (arg0.getKeyCode() == 39) {
						if (!etape) {
							if (posx + 1 <= pan2.boutons.length - 1) {
								pan2.bool[posy][posx] = false;
								posx += 1;
								pan2.bool[posy][posx] = true;
							}
						} else {
							if (selection + 1 <= pan.PV2.size() - 1) {
								selection++;
								pan.cursor += 70;
								pan.repaint();

							}
						}
						pan2.repaint();
					}
					if (arg0.getKeyCode() == 40) {
						if (!etape) {
							if (posy + 1 <= pan2.boutons[0].length - 1) {
								pan2.bool[posy][posx] = false;
								posy += 1;
								pan2.bool[posy][posx] = true;
							}
						} else {

						}
						pan2.repaint();
					}
					// Valider
					if (arg0.getKeyCode() == 10) {
						if (posx == 0 && posy == 0) {
							// une attaque

							if (etape) {
								// if (!active) {

								// deplacement.start();
								etape = false;

								actionman.add(0);
								select.add(selection);
								inc++;
								if (inc >= 3) {
									inc = 0;
									deplacement = new Thread(
											new Exec(actionman));
									deplacement.start();
									actionman = new ArrayList<Integer>();

								}
								pan2.perso(inc);
								pan2.repaint();

								// }
							} else {
								// Passer d'une etape a l'autre
								etape = true;
							}
							// juste ne pas appuyer plusieur fois
							active = true;
						} else if (posx == 1 && posy == 0) {
							if (etape) {
								etape = false;

								actionman.add(1);
								select.add(selection);
								inc++;
								if (inc >= 3) {
									inc = 0;
									deplacement = new Thread(
											new Exec(actionman));
									deplacement.start();
									actionman = new ArrayList<Integer>();
								}
								pan2.perso(inc);
								pan2.repaint();
								System.out.println("ok");
							} else {
								etape = true;
							}
						} else if (posx == 0 && posy == 1) {
							if (etape) {
								etape = false;

								actionman.add(-1);
								select.add(selection);
								inc++;
								if (inc >= 3) {
									inc = 0;
									deplacement = new Thread(
											new Exec(actionman));
									deplacement.start();
									actionman = new ArrayList<Integer>();
								}
								pan2.perso(inc);
								pan2.repaint();
								System.out.println("ok");
							} else {
								etape = true;
							}
						}

					}
				} else {
					// si ce n'est pas notre tour

				}
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	ArrayList<Integer> mort = new ArrayList<Integer>();
	boolean tour = true; // true = notre tour ,false = joueur adverse

	boolean active = false;// verifie que l'on n'apuie que une fois sur une
							// touche

	boolean etape = false;// etape 1 et 2

	int inc = 0;// permet de savoir si on est pavel cyntia ou sophia (0,1,2)

	class Deplacement implements Runnable {

		public void verif() {
			if (pan.PV.get(0) <= 0) {
				pan.PV.set(0, 0);
				pan.PP.set(0, 0);
				pan.NAME.set(0, "DEAD");
				movePavel(3);
			}
			if (pan.PV.get(1) <= 0) {
				pan.PV.set(1, 0);
				pan.PP.set(1, 0);
				pan.NAME.set(1, "DEAD2");
				moveCyntia(3);
			}
			if (pan.PV.get(2) <= 0) {
				pan.PV.set(2, 0);
				pan.PP.set(2, 0);
				pan.NAME.set(2, "DEAD3");
				moveWitch(2);
			}

		}

		public void run() {
			// Pour le moment car il n'y a que deadman et Golem

			if (pan.PV2.get(0) <= 0) {
				pan.avancem[1] = 42;

			} else {

				moveDead((int) (Math.random() * 3));
				stand();
			}
			if (pan.PV2.get(1) <= 0) {
				pan.avancem[0] = 42;

			} else {
				moveGolem((int) (Math.random() * 2));
				stand();
			}
			verif();

			tour = true;
		}
	}

	// classe qui execture les commande
	class Exec implements Runnable {
		ArrayList<Integer> ar;

		public Exec(ArrayList<Integer> ar) {
			this.ar = ar;
		}

		public void run() {
			if (ar.get(0) != null)
				if (ar.get(0) == 1 && pan.PP.get(0) <= 0) {
				} else if (pan.PV.get(0) <= 0) {
				} else
					movePavel(ar.get(0));
			stand();
			if (ar.get(1) != null)
				if (ar.get(1) == 1 && pan.PP.get(1) <= 0) {
				} else if (pan.PV.get(1) <= 0) {
				} else
					moveCyntia(ar.get(1));
			stand();
			if (ar.get(2) != null)
				if (ar.get(2) == 0 && pan.PP.get(2) <= 0) {
				} else if (pan.PV.get(2) <= 0) {
				} else
					moveWitch(ar.get(2));
			stand();
			tour = false;
			select = new ArrayList<Integer>();
			attack = new Thread(new Deplacement());
			attack.start();
		}
	}

	class Pause implements Runnable {
		public void run() {
			/*
			 * pan.orientation = 0; while (true) { for (int i = 0; i < 3; i++) {
			 * pan.avance++; pause(300); pan.repaint(); } pan.avance = 0; }
			 */

		}
	}

	public void stand() {
		if (pan.PV.get(0) != 0) {
			pan.orientation = 0;
			pan.avance = 1;
		}
		if (pan.PV.get(1) != 0) {
			pan.orientation2 = 0;
			pan.avance2 = 1;
		}
		if (pan.PV.get(2) != 0) {
			pan.orientation3 = 0;
			pan.avance3 = 1;
		}
		pan.magikp = false;
		pan.magikc = false;
		pan.magikw = false;
		pan.magikM = false;
		pan.i = 0;
		pan.repaint();
	}

	public void movePavel(int opt) {
		if (opt == 0) {
			// Attack simple
			pan.orientation = 0;
			for (int i = 0; i < 4; i++) {
				pan.avance++;
				pan.x -= 40;
				pan.repaint();
				pause(200);
			}
			pan.avance = 1;
			for (int i = 0; i < 4; i++) {

				pan.x += 40;
				pan.repaint();
				pause(200);
			}

			pan.PV2.set(select.get(0), pan.PV2.get(selection) - 20);

		} else if (opt == 1) {
			// cout de magie Noir
			pan.PP.set(0, pan.PP.get(0) - 20);
			pan.orientation = 1;
			pan.avance = 0;
			for (int i = 0; i < 3; i++) {
				pan.avance++;

				pan.repaint();
				pause(300);
			}
			pan.magikp = true;
			pan.repaint();
			pause(2000);
			pan.PV2.set(select.get(0), pan.PV2.get(selection) - 35);
			// pan.orientation = 0;
			// pan.avance = 1;

		} else if (opt == 2) {
			// hurt

			pan.orientation = 2;
			pan.avance = 1;
			pause(200);
			pan.repaint();

		} else if (opt == 3) {
			// Dead
			pan.orientation = 2;
			pan.avance = 0;
			for (int i = 0; i < 3; i++) {
				pan.avance++;
				pan.repaint();
				pause(200);
			}
			pan.repaint();

		}
	}

	public void moveCyntia(int opt) {
		if (opt == 2) {
			// Coup en retrait d'elf
			pan.orientation2 = 0;
			pan.avance2 = 0;
			for (int i = 0; i < 3; i++) {
				pan.avance2++;
				pan.repaint();
				pause(200);
			}
		} else if (opt == 0) {
			// attack avec un arc de magie noir

			pan.orientation2 = 3;
			pan.avance2 = 0;
			for (int i = 0; i < 4; i++) {
				pan.avance2++;
				if (i <= 2) {
					pan.x2 -= 50;
					pan.y2 -= 40;
				} else {

				}
				pan.repaint();
				pause(200);

			}
			for (int i = 0; i < 3; i++) {
				pan.avance2 = 2;
				pan.x2 += 50;
				pan.y2 += 40;
				pan.repaint();
				pause(200);
				pan.avance2 = 1;
			}
			pan.orientation2 = 0;
			pan.avance2 = 1;
			pan.repaint();
			pan.PV2.set(select.get(1), pan.PV2.get(selection) - 30);
		} else if (opt == 1) {
			// magic blinda
			pan.PP.set(1, pan.PP.get(1) - 20);
			pan.orientation2 = 2;
			pan.avance2 = 0;
			for (int i = 0; i < 2; i++) {
				pan.avance2++;
				pan.repaint();
				pause(200);
			}
			pan.magikc = true;
			pan.repaint();
			pan.PV2.set(select.get(1), pan.PV2.get(selection) - 40);
			pause(2000);
		} else if (opt == 3) {
			// hurt dead
			pan.orientation2 = 1;
			pan.avance2 = 0;
			for (int i = 0; i < 2; i++) {
				pan.avance2++;
				pan.repaint();
				pause(200);
			}
		}
	}

	public void moveWitch(int opt) {
		if (opt == 0) {
			// Jetter un sort permet surtout de guerrir ses soldats
			pan.PP.set(2, pan.PP.get(2) - 10);
			for (int i = 0; i < 2; i++) {
				pan.PV.set(i, pan.PV.get(i) + 10);
			}
			pan.orientation3 = 0;
			pan.avance3 = 0;
			pan.magikw = true;
			for (int i = 0; i < 4; i++) {
				pan.avance3++;
				pan.repaint();
				pause(500);
			}
			pan.PV2.set(select.get(2), pan.PV2.get(selection) - 15);

		} else if (opt == 2) {
			pan.avance3 = 0;
			for (int i = 0; i < 2; i++) {
				pan.orientation3 = 1;
				pan.avance3++;
				pan.repaint();
				pause(200);
			}
		}
	}

	public void moveGolem(int cible) {
		for (int i = 0; i < 5; i++) {
			pan.avancem[0]++;
			pan.tx[0] += 20;
			pan.repaint();
			pause(200);
		}
		pan.avancem[0] = 1;
		switch (cible) {
		case 0:
			movePavel(2);
			pan.PV.set(0, pan.PV.get(0) - 20);
			break;
		case 1:
			moveCyntia(3);
			pan.PV.set(1, pan.PV.get(1) - 30);
			break;

		case 2:
			moveWitch(2);
			pan.PV.set(2, pan.PV.get(2) - 40);
			break;
		}

		for (int i = 0; i < 5; i++) {
			pan.tx[0] -= 20;
			pan.repaint();
			pause(100);
		}
	}

	public void moveDead(int deg) {
		if (deg == 0) {
			for (int i = 0; i < 3; i++) {
				pan.avancem[1]++;
				pan.tx[1] += 70;
				pause(800);
				pan.repaint();
			}
			for (int i = 0; i < 3; i++) {
				pan.tx[1] -= 70;
				pan.avancem[1] = 1;
				pan.repaint();
			}
			pan.PV.set(0, pan.PV.get(0) - 20);
			pan.PV.set(1, pan.PV.get(1) - 20);
			pan.PV.set(2, pan.PV.get(2) - 20);

		} else if (deg == 1) {
			for (int i = 0; i < 4; i++) {
				pan.tx[1] += 70;
				pan.ty[1] -= 50;
				pan.magikc = true;

				pan.repaint();
				pause(400);

			}
			for (int i = 0; i < 4; i++) {
				pan.tx[1] -= 70;
				pan.ty[1] += 50;
				pan.magikc = false;
				pan.magikp = true;
				pan.repaint();
				pause(200);
			}
			pan.PV.set(0, pan.PV.get(0) - 20);
			pan.PV.set(1, pan.PV.get(1) - 30);
			pan.PV.set(2, pan.PV.get(2) - 30);

		} else if (deg == 2) {
			pan.magikM = true;
			for (int i = 0; i < 15; i++) {
				pan.i++;
				pan.repaint();
				pause(300);
			}
			pan.PV.set(0, pan.PV.get(0) - 40);
			pan.PV.set(1, pan.PV.get(1) - 50);
			pan.PV.set(2, pan.PV.get(2) - 50);

		}
		movePavel(2);
		moveCyntia(3);
		moveWitch(2);
	}

	ArrayList<Integer> select = new ArrayList<Integer>();

	public static void main(String[] args) {
		new Fenetre();
	}
}

