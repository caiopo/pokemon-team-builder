package main;

import util.PokedexWrapper;
import window.MainMenuWindow;

public class Main {

	public static void main(String[] args) {

		PokedexWrapper pokedex = new PokedexWrapper();

		MainMenuWindow window = new MainMenuWindow(pokedex);
	}

}
