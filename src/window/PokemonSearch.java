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

		wDialog = new WaitingDialog("Searching...", TITLE);

		System.out.println("Started search");
		Pokemon[] searchResult = pokedex.searchPokemon(input);
		System.out.println("Finished search");

		return searchResult;

	}

	public Pokemon makeResultWindow(Pokemon[] pokemons) {
		System.out.println("Started the result window");

		JPanel panel = new JPanel(new GridLayout(0, Math.min(5, pokemons.length)));
		ButtonGroup bg = new ButtonGroup();
		ArrayList<JRadioButton> jrbs = new ArrayList<>(pokemons.length);

		System.out.println("Changing dialog message");

		wDialog.setMessage("Fetching images...");

		System.out.println("Changed dialog message");

		for (Pokemon pokemon : pokemons) {

			JRadioButton jrb = new JRadioButton(pokemon.getName(), pokemon.getIcon());

			bg.add(jrb);

			panel.add(jrb);

			jrbs.add(jrb);
			// JButton jb = new JButton(pokemon.getName(),
			// ImageManager.loadPokeImage(pokemon));
			//
			// jb.addActionListener();

		}

		wDialog.dispose();

		Pokemon pokemon = null;

		do {

			JOptionPane.showMessageDialog(null, panel, "Select the desired Pokemon", JOptionPane.PLAIN_MESSAGE);

			for (JRadioButton jrb : jrbs)
				if (jrb.isSelected())
					for (Pokemon poke : pokemons)
						if (poke.getName().equalsIgnoreCase(jrb.getText()))
							pokemon = poke;

		} while (pokemon == null);

		assert (pokemon != null);

		return pokemon;
	}
}
