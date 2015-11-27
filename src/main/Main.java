package main;

import javax.swing.JOptionPane;

import com.pokejava.Pokemon;

import util.PokedexWrapper;
import window.ImageManager;
import window.PokemonSearch;

public class Main {

	public static void main(String[] args) {

		PokedexWrapper p = (PokedexWrapper) new PokedexWrapper();

		Pokemon search = PokemonSearch.open(p);

		System.out.println(search);

		JOptionPane.showMessageDialog(null, search.getIcon());

		// testImage(search);

		// pikachu.get

	}

	public static void testImage(Pokemon poke) {

		JOptionPane.showMessageDialog(null, ImageManager.loadPokeImage(poke));

	}

}
