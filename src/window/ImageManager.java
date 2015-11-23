package window;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageManager {

	public static ImageIcon loadImageFromURL(String url) {

		Image temp = Toolkit.getDefaultToolkit().createImage(url);

		return new ImageIcon(temp);
	}

	public static void main(String[] args) {
		// Image img =
		// Toolkit.getDefaultToolkit().createImage(WindowManager.baseURL +
		// "/media/img/1383571573.78.png");
		
		// Image img = null;
		// try {
		// img = ImageIO.read(new URL(WindowManager.baseURL +
		// "/media/img/1383571573.78.png"));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		BufferedImage img;
		try {

			img = ImageIO.read(new URL(WindowManager.baseURL + "/media/img/6.png").openStream());
			JOptionPane.showMessageDialog(null, new JPanel().add(new JLabel(new ImageIcon(img))));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
