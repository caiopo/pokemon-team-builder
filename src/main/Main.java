package main;

import util.PokedexWrapper;
import window.TeamBuilderWindowManager;

public class Main {

	public static void main(String[] args) {
		// new PokemonDescriptionWindow(new Pokemon("riolu"));
		new TeamBuilderWindowManager(null, new PokedexWrapper());
	}

}
