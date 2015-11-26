package window;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.pokejava.Pokemon;

import exceptions.PokemonNotFoundException;
import util.PokedexWrapper;

public class PokemonSearch {

	public static Pokemon open(PokedexWrapper pokedex) {
		Pokemon[] input = input(pokedex);

		for (Pokemon poke : input) {
			System.out.println(poke);
		}

		System.out.println("FINISHED");

		return makeResultWindow(input);
	}

	public static Pokemon[] input(PokedexWrapper pokedex) {

		JPanel panel = new JPanel();

		// panel.setb

		JTextField jtf = new JTextField(20);
		panel.add(jtf);

		JOptionPane.showMessageDialog(null, panel, "Search Pokemon", JOptionPane.PLAIN_MESSAGE);

		String input = jtf.getText();

		// TODO Waiting window

		Pokemon[] searchResult = pokedex.searchPokemon(input);

		return searchResult;

	}

	public static Pokemon makeResultWindow(Pokemon[] pokemons) {

		Pokemon chosen;

		JPanel panel = new JPanel(new GridLayout(0, Math.min(5, pokemons.length)));
		ButtonGroup bg = new ButtonGroup();
		ArrayList<JRadioButton> jrbs = new ArrayList<>(pokemons.length);

		for (Pokemon pokemon : pokemons) {

			JRadioButton jrb = new JRadioButton(pokemon.getName(), ImageManager.loadPokeImage(pokemon));

			bg.add(jrb);

			panel.add(jrb);

			jrbs.add(jrb);
			// JButton jb = new JButton(pokemon.getName(),
			// ImageManager.loadPokeImage(pokemon));
			//
			// jb.addActionListener();

		}

		JOptionPane.showMessageDialog(null, panel, "Select the desired Pokemon", JOptionPane.PLAIN_MESSAGE);

		for (JRadioButton jrb : jrbs)
			if (jrb.isSelected())
				for (Pokemon poke : pokemons)
					if (poke.getName().equalsIgnoreCase(jrb.getText()))
						return poke;

		throw new PokemonNotFoundException();

		// throw new IllegalArgumentException();
	}
}
