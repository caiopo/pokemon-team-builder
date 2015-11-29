package objects;

import java.util.ArrayList;
import java.util.List;

import com.pokejava.Pokedex;
import com.pokejava.Pokemon;

public class PokedexWrapper {

	private Pokedex pokedex;

	public static final int MAX_POKEDEX = 718;

	private List<String> names;

	public PokedexWrapper() {
		pokedex = new Pokedex();
		names = pokedex.getPokemonNamesList();
	}

	public String[] searchName(String name) {
		List<String> filtered = new ArrayList<>();

		for (int i = 1; i < MAX_POKEDEX; i++)
			if (names.get(i).contains(name))
				filtered.add(names.get(i));

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

	public List<String> getNames() {
		return names;
	}

}
