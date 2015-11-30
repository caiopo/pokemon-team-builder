package window;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.pokejava.Pokemon;

import objects.PokedexWrapper;

public class PokemonSearch {

	public static Pokemon open(PokedexWrapper pokedex) {
		System.out.println("Creating: " + PokemonSearch.class.getName());

		PokemonSearchWindow search = new PokemonSearchWindow();

		Pokemon[] input = search.input(pokedex);

		if (input == null) {
			search.wDialog.dispose();
			JOptionPane.showMessageDialog(null, "Pokemon not found!", "Search Pokemon", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		return search.makeResultWindow(input);
	}

}

class PokemonSearchWindow {

	public final static String TITLE = "Search Pokemon";

	public WaitingDialog wDialog;

	public Pokemon[] input(PokedexWrapper pokedex) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(new JLabel("Enter the name of the Pokemon you are looking for"));

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		JTextField jtf = new JTextField();
		panel.add(jtf);

		JOptionPane.showMessageDialog(null, panel, TITLE, JOptionPane.PLAIN_MESSAGE);

		String input = jtf.getText();

		if (input.isEmpty())
			return null;

		wDialog = new WaitingDialog("Searching", "Wait");

		Pokemon[] searchResult = pokedex.searchPokemon(input);

		return searchResult;

	}

	public Pokemon makeResultWindow(Pokemon[] pokemons) {

		if (pokemons == null) {
			wDialog.dispose();
			return null;
		}

		if (pokemons.length == 1) {
			wDialog.dispose();
			return pokemons[0];
		}

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
