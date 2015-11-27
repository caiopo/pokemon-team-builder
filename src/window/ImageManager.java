package window;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
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

		// System.out.println(url);

		BufferedImage temp = null;

		try {
			temp = ImageIO.read(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ImageIcon(temp);
	}

	// public static BufferedImage loadImageFromURL2(String url) {
	//
	// System.out.println(url);
	//
	// BufferedImage temp = null;
	//
	// try {
	// temp = ImageIO.read(new URL(url));
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// // Image temp = Toolkit.getDefaultToolkit().createImage(url);
	//
	// return temp;
	// }

}
