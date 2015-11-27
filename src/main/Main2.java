package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pokejava.Pokemon;

import objects.Team;
import util.PokeUtils;

public class Main2 {

	public static void main(String[] args) {

		Random rng = new Random(System.currentTimeMillis());

		Team team = new Team();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			Pokemon randPoke = new Pokemon(rng.nextInt(PokeUtils.MAX_POKEDEX));

			System.out.println(randPoke.toString() + " " + randPoke.getID());

			team.add(randPoke);

		}

		JPanel jpanel = new JPanel();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			// System.out.println(team.get(i).getIcon().getIconWidth() + ", " +
			// team.get(i).getIcon().getIconHeight());

			JButton jb = new JButton(team.get(i).getIcon());

			jb.setSize(new Dimension(120, 120));

			final String str = team.get(i).toString();

			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, str);
				}
			});

			jpanel.add(jb);
		}

		JOptionPane.showMessageDialog(null, jpanel);

	}
}
