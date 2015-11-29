package window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingDialog2 {

	private JFrame frame;
	private JPanel panel;
	private JLabel label;

	public WaitingDialog2(String message, String title) {

		label = new JLabel(message);

		frame = new JFrame(title);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(label);

		frame.setContentPane(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// frame.setResizable(false);
		frame.setVisible(true);
	}

	public void dispose() {

		frame.dispose();
	}

}
