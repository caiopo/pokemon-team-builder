package main;

import util.PokedexWrapper;
import window.MainMenuWindow;
import window.TeamBuilderWindowManager;

public class Main {

	public static void main(String[] args) {
		try {
			MainMenuWindow window = new MainMenuWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
