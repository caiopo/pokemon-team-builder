package util;

import java.util.ArrayList;
import java.util.List;

import com.pokejava.Pokemon;

public class PokeUtils {

	public static final int MAX_POKEDEX = 718;
	public static final String BASE_URL = "http://pokeapi.co";

	public static Pokemon fetchPokemon(int id) {
		if (id <= MAX_POKEDEX && id >= 1) {
			return new Pokemon(id);
		} else {
			throw new IllegalArgumentException("No pokemon has the ID " + id);
		}

	}

	public static List<Integer> indexContains(List<String> list, String element) {
		List<Integer> listInt = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toLowerCase().contains(element.toLowerCase())) {
				listInt.add(i);
			}
		}

		return listInt;
	}

}