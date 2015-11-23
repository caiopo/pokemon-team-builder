package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.pokejava.*;

import util.PokeUtils;

public class Main {
	public static void main(String[] args) {

		// int id = 151;
		//
		// Pokemon bulbasaur = new Pokemon(id);
		// System.out.println(bulbasaur.toString());
		//
		// System.out.println(bulbasaur.getDescriptions().get(0).getID());

		Pokedex p = new Pokedex();

		// System.out.printf("%b, %d", p.hasPokemon(), p.getPokemons().size());'

		System.out.println(p.getPokemonsNames());

		System.out.println(p.getPokemonsNames().size());

		List<String> pokes = Arrays
				.asList(((String[]) p.getPokemonsNames().toArray(new String[p.getPokemonsNames().size()])));

		for (int i = 0; i < pokes.size(); i++) {

			System.out.println(pokes.get(i) + " " + i);

		}

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
		}

		// for (Pokemon poke : p.getPokemons()) {
		// System.out.println(poke.toString());
		// }

		// System.out.println(p.getPokemons().toString());

	}
}
