package window;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.pokejava.Pokemon;

import util.PokedexWrapper;

public class PokemonSearch {

	public static Pokemon open(PokedexWrapper pokedex) {

		PokemonSearchWindow search = new PokemonSearchWindow();

		Pokemon[] input = search.input(pokedex);

		return search.makeResultWindow(input);
	}

}

class PokemonSearchWindow {

	public static String TITLE = "Search Pokemon";

	private WaitingDialog wDialog;

	public Pokemon[] input(PokedexWrapper pokedex) {

		JPanel panel = new JPanel();

		JTextField jtf = new JTextField(20);
		panel.add(jtf);

		JOptionPane.showMessageDialog(null, panel, TITLE, JOptionPane.PLAIN_MESSAGE);

		String input = jtf.getText();

		if (input.isEmpty())
			return null;

		System.out.println("Creating window");

		wDialog = new WaitingDialog("Searching...", "Wait");

		System.out.println("Started search");
		Pokemon[] searchResult = pokedex.searchPokemon(input);
		System.out.println("Finished search");

		return searchResult;

	}

	public Pokemon makeResultWindow(Pokemon[] pokemons) {
		System.out.println("Started the result window");

		if (pokemons == null)
			return null;

		JPanel panel = new JPanel(new GridLayout(0, Math.min(5, pokemons.length)));
		ButtonGroup bg = new ButtonGroup();
		ArrayList<JRadioButton> jrbs = new ArrayList<>(pokemons.length);

		for (Pokemon pokemon : pokemons) {

			JRadioButton jrb = new JRadioButton(pokemon.getName(), pokemon.getIcon());

			bg.add(jrb);

			panel.add(jrb);

			jrbs.add(jrb);

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
