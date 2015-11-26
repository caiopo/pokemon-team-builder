package window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class WaitingDialog {

	private JDialog dialog;
	private JOptionPane pane;

	public WaitingDialog(String message, String title) {
		pane = new JOptionPane(message);
		dialog = pane.createDialog(null, title);
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);

	}

	public void setMessage(String message) {
		pane.setMessage(message);
	}

	public void dispose() {
		dialog.dispose();
	}

}
