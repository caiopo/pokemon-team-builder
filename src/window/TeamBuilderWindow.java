package window;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.pokejava.Pokemon;

import main.Main;
import objects.Team;

public class TeamBuilderWindow {

	private JFrame frame;

	private JButton[] btnPoke = new JButton[Team.MAX_SIZE];

	private JMenuItem export;

	private JMenuItem[] rmPoke = new JMenuItem[Team.MAX_SIZE];

	/**
	 * Create the application.
	 */
	public TeamBuilderWindow() {
		System.out.println("Creating: " + this.getClass().getName());

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Pokemon Team Builder");
		frame.getContentPane().setSize(new Dimension(1000, 800));
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setSize(new Dimension(1000, 800));

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});

		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(3, 2, 0, 0));

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JMenuBar menuBar = new JMenuBar();

		JMenu menuRemove = new JMenu("Remove from Team");

		for (int i = 0; i < Team.MAX_SIZE; i++) {
			btnPoke[i] = new JButton("Click to add a Pokemon");
			panel.add(btnPoke[i]);

			rmPoke[i] = new JMenuItem("Pokemon " + (i + 1));
			menuRemove.add(rmPoke[i]);
		}

		export = new JMenuItem("Export");

		JMenu menuExport = new JMenu("Export");
		menuExport.add(export);

		menuBar.add(menuExport);
		menuBar.add(menuRemove);

		frame.setJMenuBar(menuBar);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	public void setPokemon(Pokemon pokemon, int index) {
		if (pokemon != null) {

			btnPoke[index].setIcon(pokemon.getIcon());
			btnPoke[index].setText(pokemon.getName());
		} else {
			btnPoke[index].setIcon(null);
			btnPoke[index].setText("Click to add a Pokemon");
		}
	}

	public void update(Team team) {
		for (int i = 0; i < Team.MAX_SIZE; i++) {
			setPokemon(team.get(i), i);
		}
	}

	public void addButtonListener(int index, ActionListener l) {
		btnPoke[index].addActionListener(l);
	}

	public void addExportListener(ActionListener l) {
		export.addActionListener(l);
	}

	public void addMenuItemListener(int index, ActionListener l) {
		rmPoke[index].addActionListener(l);
	}

	private void close() {

		frame.dispose();

		Main.showMainWindow();
	}
}