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
	private Pokemon pokemon;

	public PokemonInfoWindow(Pokemon pokemon) {
		this.pokemon = pokemon;
		ArrayList<Ability> abilities = pokemon.getAbilities();

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel(pokemon.getIcon()));

		panel.add(new JLabel("Name: " + pokemon.getName()));
		panel.add(new JLabel("ID: " + pokemon.getID()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		double height = Double.parseDouble(pokemon.getHeight()) / 10;
		double weight = Double.parseDouble(pokemon.getWeight()) / 10;

		panel.add(new JLabel("Height: " + height + " m"));
		panel.add(new JLabel("Weight: " + weight + " kg"));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(new JLabel("HP: " + pokemon.getHP()));
		panel.add(new JLabel("Attack: " + pokemon.getAttack()));
		panel.add(new JLabel("Special Attack: " + pokemon.getSpAttack()));
		panel.add(new JLabel("Defense: " + pokemon.getDefense()));
		panel.add(new JLabel("Special Defense: " + pokemon.getSpDefense()));
		panel.add(new JLabel("Speed: " + pokemon.getSpeed()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		if (abilities.size() == 1)
			panel.add(new JLabel("Ability: " + abilities.get(0).getName()));
		else
			for (int i = 0; i < abilities.size(); i++)
				panel.add(new JLabel("Ability #" + (i + 1) + ": " + abilities.get(i).getName()));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		// TODO add more infos if possible

		frame = new JFrame("Pokemon Info");

		JButton descriptionButton = new JButton("Descriptions");
		descriptionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PokemonDescriptionWindow(PokemonInfoWindow.this.pokemon);
			}
		});
		panel.add(descriptionButton);

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.requestFocus();

	}

	public void dispose() {
		frame.dispose();
	}

}
