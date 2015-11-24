package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pokejava.Pokemon;

import objects.Team;
import util.PokeUtils;
import window.ImageManager;

public class Main {

	public static void main(String[] args) {

		Random rng = new Random(System.currentTimeMillis());

		Team team = new Team();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			team.add(new Pokemon(rng.nextInt(PokeUtils.MAX_POKEDEX)));

		}

		JPanel jpanel = new JPanel();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			final Pokemon p = team.get(i);

			ImageIcon icon = ImageManager.loadPokeImage(team.get(i));

			System.out.println(icon.getIconWidth() + ", " + icon.getIconHeight());

			JButton jb = new JButton(icon);

			jb.setSize(new Dimension(120, 120));

			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, p.toString());
				}
			});

			jpanel.add(jb);
		}

		JOptionPane.showMessageDialog(null, jpanel);

	}
}
