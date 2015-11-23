package window;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {

	private JFrame frame;
	private JLabel lblPoke5;
	private JLabel lblPoke6;
	private JLabel lblPoke3;
	private JLabel lblPoke1;
	private JLabel lblPoke4;
	private JLabel lblPoke2;

	/**
	 * Launch the application.
	 */
	public static void startWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1000, 600));
		frame.setLocationRelativeTo(null);

		lblPoke1 = new JLabel("none");

		lblPoke2 = new JLabel("none");

		lblPoke3 = new JLabel("none");

		lblPoke4 = new JLabel("none");

		lblPoke5 = new JLabel("none");

		lblPoke6 = new JLabel("none");

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(72)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblPoke1)
								.addComponent(lblPoke2).addComponent(lblPoke3))
						.addGap(99).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblPoke6)
								.addComponent(lblPoke5).addComponent(lblPoke4))
						.addContainerGap(689, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(64)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPoke1)
								.addComponent(lblPoke4))
				.addGap(58)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPoke2)
						.addComponent(lblPoke5)).addGap(46)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPoke3)
						.addComponent(lblPoke6)).addContainerGap(350, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}

	public JLabel getLblPoke1() {
		return lblPoke1;
	}

	public JLabel getLblPoke2() {
		return lblPoke2;
	}

	public JLabel getLblPoke3() {
		return lblPoke3;
	}

	public JLabel getLblPoke4() {
		return lblPoke4;
	}

	public JLabel getLblPoke5() {
		return lblPoke5;
	}

	public JLabel getLblPoke6() {
		return lblPoke6;
	}
}
