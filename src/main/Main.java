package main;

import objects.PokedexWrapper;
import window.MainMenuWindow;

public class Main {

	private static MainMenuWindow mainWindow;

	public static void main(String[] args) {

		PokedexWrapper pokedex = new PokedexWrapper();

		mainWindow = new MainMenuWindow(pokedex);

	}

	public static void showMainWindow() {
		System.out.println("Going back to MainWindow");
		mainWindow.show();
	}

}
