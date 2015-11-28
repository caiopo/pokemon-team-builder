package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pokejava.Pokemon;

import objects.Team;
import util.PokeUtils;
import window.PokemonInfoWindow;

public class Main2 {

	public static void main(String[] args) {

		Random rng = new Random(System.currentTimeMillis());

		Team team = new Team();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			Pokemon randPoke = new Pokemon(rng.nextInt(PokeUtils.MAX_POKEDEX));

			System.out.println(randPoke.toString() + " " + randPoke.getID());

			team.add(randPoke);

		}

		JPanel jpanel = new JPanel(new GridLayout(1, 0));
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			JButton jb = new JButton(team.get(i).getIcon());

			// jb.setSize(new Dimension(120, 120));

			final String str = team.get(i).toString();

			final Pokemon p = team.get(i);

			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new PokemonInfoWindow(p);
				}
			});

			jpanel.add(jb);
		}

		// JOptionPane.showMessageDialog(null, jpanel);

		JFrame frame = new JFrame();

		frame.setContentPane(jpanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
