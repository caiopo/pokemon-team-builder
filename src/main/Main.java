package main;

import util.PokedexWrapper;
import window.MainMenuWindow;

public class Main {

	private static MainMenuWindow mainWindow;

	public static void main(String[] args) {

		PokedexWrapper pokedex = new PokedexWrapper();

		mainWindow = new MainMenuWindow(pokedex);

	}

	public static void showMainWindow() {
		mainWindow.show();
	}

}
