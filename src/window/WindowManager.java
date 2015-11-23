package window;

import javax.swing.ImageIcon;

import util.PokeUtils;

public class WindowManager {

	public static ImageIcon img;

	public static void main(String[] args) {
		System.out.println("tchau");

		img = ImageManager.loadImageFromURL(PokeUtils.BASE_URL + "/media/img/1383571573.78.png");

		System.out.println(PokeUtils.BASE_URL + "/media/img/1383571573.78.png");

		assert (img != null);

	}

}
