package window;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import com.pokejava.Pokemon;
import com.pokejava.Sprite;

import util.PokeUtils;

public class ImageManager {

	public static ImageIcon loadPokeImage(Pokemon poke) {
		return loadPokeImage(poke.getID() + 1);

	}

	public static ImageIcon loadPokeImage(int id) {
		String url = new Sprite(id).getImage();

		return loadImageFromURL(PokeUtils.BASE_URL + url);

	}

	public static ImageIcon loadImageFromURL(String url) {

		System.out.println(url);

		Image temp = Toolkit.getDefaultToolkit().createImage(url);

		return new ImageIcon(temp);
	}

}
