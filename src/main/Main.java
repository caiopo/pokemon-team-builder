package main;

import javax.swing.JOptionPane;

import com.pokejava.Pokemon;

import util.PokedexWrapper;
import window.ImageManager;
import window.PokemonSearch;

public class Main {

	public static void main(String[] args) {
		PokedexWrapper p = (PokedexWrapper) new PokedexWrapper();

		// for (Pokemon pkmn : p.searchPokemon("pika")) {
		// testImage(pkmn);
		//
		// }

		Pokemon search = PokemonSearch.open(p);
		//
		// for (Pokemon pokemon : search) {
		// System.out.println(pokemon.toString());
		// }
		//

		System.out.println(search);

		testImage(search);

	}

	public static void testImage(Pokemon poke) {

		JOptionPane.showMessageDialog(null, ImageManager.loadPokeImage(poke));

	}

}
