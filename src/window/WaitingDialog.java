package window;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WaitingDialog {

	private JDialog dialog;

	public WaitingDialog(String message, String title) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(new JLabel(message));

		dialog = new JOptionPane(panel).createDialog(title);

		dialog.setModal(false);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
		
		
		// JOptionPane jop = new JOptionPane("aa");
		// jop.set

	}

	public void dispose() {

		dialog.dispose();
	}

}
