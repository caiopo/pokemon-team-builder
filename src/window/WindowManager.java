package window;

import javax.swing.ImageIcon;

public class WindowManager {

	// public static final String baseURL = "http://pokeapi.co/api/v1";
	public static final String baseURL = "http://pokeapi.co";

	public static ImageIcon img;

	public static void main(String[] args) {
		System.out.println("tchau");

		img = ImageManager.loadImageFromURL(baseURL + "/media/img/1383571573.78.png");

		System.out.println(baseURL + "/media/img/1383571573.78.png");
		
		assert(img != null);

	}

}
