package window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class WaitingDialog {

	public WaitingDialog() {
		JOptionPane pane = new JOptionPane("message");
		JDialog dialog = pane.createDialog(null, "Title");
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
		dialog.dispose();
	}
}
