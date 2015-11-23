package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pokejava.Pokedex;
import com.pokejava.Pokemon;
import com.pokejava.Sprite;

import util.PokeUtils;
import window.ImageManager;

public class Main {

	// public static void main(String[] args) {
	//
	// }

	// /**
	// * search poke
	// *
	// * @param args
	// */
	//
	public static void main(String[] args) {

		List<String> pokes = PokeUtils.generatePokedex();

		String name = JOptionPane.showInputDialog("");

		List<Integer> indices = PokeUtils.indexContains(pokes, name);

		List<Pokemon> filteredPokes = new ArrayList<>();

		for (int pokeIndex : indices) {
			System.out.println(pokeIndex);
		}

		for (int pokeIndex : indices) {
			filteredPokes.add(new Pokemon(pokeIndex + 1));
		}

		for (Pokemon pokemon : filteredPokes) {
			System.out.println(pokemon.toString());
			System.out.println(pokemon.getID());

		}

		for (Pokemon pokemon : filteredPokes) {

			Icon icon = ImageManager.loadPokeImage(pokemon);

			JOptionPane.showMessageDialog(null, icon);
		}

	}
}
