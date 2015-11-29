package window;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingDialog {

	private JFrame frame;
	private JPanel panel;
	private JLabel label;

	public WaitingDialog(String message, String title) {

		frame = new JFrame(title);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		label = new JLabel(message);
		panel.add(label);

		frame.setContentPane(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// frame.setResizable(false);
		frame.setVisible(true);
	}

	// public void setMessage(String message) {
	// label.setText(message);
	// }

	public void dispose() {
		frame.dispose();
	}

}
