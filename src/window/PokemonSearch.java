package window;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pokejava.Pokemon;

import util.PokedexWrapper;

public class PokemonSearch {

	public static Pokemon[] open(PokedexWrapper pokedex) {

		JPanel panel = new JPanel();

		JTextField jtf = new JTextField(20);
		panel.add(jtf);

		JOptionPane.showMessageDialog(null, panel, "Search Pokemon", JOptionPane.PLAIN_MESSAGE);

		String input = jtf.getText();

		// TODO Waiting window

		Pokemon[] searchResult = pokedex.searchPokemon(input);

		return searchResult;

	}

}