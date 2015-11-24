package util;

import java.util.ArrayList;
import java.util.List;

import com.pokejava.Pokedex;
import com.pokejava.Pokemon;

public class PokedexWrapper {

	private Pokedex pokedex;

	private List<String> names;

	public PokedexWrapper() {
		pokedex = new Pokedex();
		names = pokedex.getPokemonNamesList();
	}

	public String[] searchName(String name) {
		List<String> filtered = new ArrayList<>();

		for (String n : names)
			if (n.contains(name))
				filtered.add(n);
		return filtered.toArray(new String[filtered.size()]);
	}

	public Pokemon[] searchPokemon(String name) {

		String[] filtered = searchName(name);

		Pokemon[] pokes = new Pokemon[filtered.length];

		for (int i = 0; i < filtered.length; i++) {
			pokes[i] = new Pokemon(filtered[i]);
		}

		return pokes;

	}

}
