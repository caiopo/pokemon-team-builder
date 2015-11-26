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

		// for (String n : names)
		// if (n != null && n.contains(name))
		// filtered.add(n);

		for (int i = 1; i < PokeUtils.MAX_POKEDEX; i++)
			if (names.get(i).contains(name))
				filtered.add(names.get(i));

		return filtered.toArray(new String[filtered.size()]);
	}

	public Pokemon[] searchPokemon(String name) {

		String[] filtered = searchName(name);

		Pokemon[] pokes = new Pokemon[filtered.length];

		// System.out.println("start filtered");
		// for (String string : filtered) {
		// System.out.println(string);
		// }
		// System.out.println("start filtered");

		for (int i = 0; i < filtered.length; i++) {
			pokes[i] = new Pokemon(filtered[i]);
		}

		return pokes;

	}

}
