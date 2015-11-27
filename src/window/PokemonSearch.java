package window;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.pokejava.Pokemon;

import exceptions.IllegalInputException;
import exceptions.PokemonNotFoundException;
import util.PokedexWrapper;

public class PokemonSearch {

	public static Pokemon open(PokedexWrapper pokedex) {

		PokemonSearchWindow search = new PokemonSearchWindow();

		Pokemon[] input = search.input(pokedex);

		return search.makeResultWindow(input);
	}

	// -------------------------
}

class PokemonSearchWindow {

	public static String TITLE = "Search Pokemon";

	private WaitingDialog wDialog;

	public Pokemon[] input(PokedexWrapper pokedex) {

		JPanel panel = new JPanel();

		// panel.setb

		JTextField jtf = new JTextField(20);
		panel.add(jtf);

		JOptionPane.showMessageDialog(null, panel, TITLE, JOptionPane.PLAIN_MESSAGE);

		String input = jtf.getText();

		if (input.isEmpty())
			throw new IllegalInputException();

		System.out.println("Creating window");

		// TODO Waiting window

		// dialog = new WaitingDialog("Searching...", TITLE);

		Pokemon[] searchResult = pokedex.searchPokemon(input);

		return searchResult;

	}

	public Pokemon makeResultWindow(Pokemon[] pokemons) {

		JPanel panel = new JPanel(new GridLayout(0, Math.min(5, pokemons.length)));
		ButtonGroup bg = new ButtonGroup();
		ArrayList<JRadioButton> jrbs = new ArrayList<>(pokemons.length);

		// dialog.setMessage("Fetching images...");

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

		// dialog.dispose();

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
