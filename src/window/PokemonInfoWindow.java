package window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pokejava.Ability;
import com.pokejava.Pokemon;

public class PokemonInfoWindow {

	private JFrame frame;

	public PokemonInfoWindow(Pokemon pokemon) {

		ArrayList<Ability> abilities = pokemon.getAbilities();

		// GridLayout grid = new GridLayout(0, 1);
		//
		// grid.setVgap(-100);
		//
		// System.out.println(grid.getVgap() + " " + grid.getHgap());

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel(pokemon.getIcon()));

		panel.add(new JLabel("Name: " + pokemon.getName()));
		panel.add(new JLabel("ID: " + pokemon.getID()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(new JLabel("Height: " + pokemon.getHeight()));
		panel.add(new JLabel("Weight" + pokemon.getWeight()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(new JLabel("HP: " + pokemon.getHP()));
		panel.add(new JLabel("Attack: " + pokemon.getAttack()));
		panel.add(new JLabel("Special Attack: " + pokemon.getSpAttack()));
		panel.add(new JLabel("Defense: " + pokemon.getDefense()));
		panel.add(new JLabel("Special Defense: " + pokemon.getSpDefense()));
		panel.add(new JLabel("Speed: " + pokemon.getSpeed()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		if (pokemon.getEvolvesAt() == -2)
			panel.add(new JLabel("Evolution: Special"));
		else if (pokemon.getEvolvesAt() == -1)
			panel.add(new JLabel("Evolution: None"));
		else
			panel.add(new JLabel("Evolves at: " + pokemon.getEvolvesAt()));

		// TODO add more infos if possible

		// panel.add(new JLabel("M/F: " + pokemon.getMFRatio()));
		// panel.add(new JLabel("Catch rate: " + pokemon.getCatchRate()));
		// panel.add(new JLabel("Base friendship: " + pokemon.getHappiness()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		if (abilities.size() == 1)
			panel.add(new JLabel("Ability: " + abilities.get(0).getName()));
		else
			for (int i = 0; i < abilities.size(); i++)
				panel.add(new JLabel("Ability #" + (i + 1) + ": " + abilities.get(i).getName()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		frame = new JFrame("Pokemon Info");

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		panel.add(closeButton);

		frame.add(panel);

		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void dispose() {
		frame.dispose();
	}

}
