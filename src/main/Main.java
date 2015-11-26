package main;

import com.pokejava.Pokemon;

import util.PokedexWrapper;
import window.PokemonSearch;

public class Main {

	public static void main(String[] args) {

		PokedexWrapper p = new PokedexWrapper();
		Pokemon[] search = PokemonSearch.open(p);

		for (Pokemon pokemon : search) {
			System.out.println(pokemon.toString());
		}

	}

}
