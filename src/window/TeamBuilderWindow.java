package window;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pokejava.Pokemon;

import objects.Team;

public class TeamBuilderWindow {

	private JFrame frame;

	// private JButton btnPoke1, btnPoke2, btnPoke3, btnPoke4, btnPoke5,
	// btnPoke6;

	private JButton[] btnPoke = new JButton[Team.MAX_SIZE];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBuilderWindow window = new TeamBuilderWindow();
					window.frame.setVisible(true);
					window.setPokemon(new Pokemon("lucario"), 0);
					window.setPokemon(new Pokemon("pikachu"), 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamBuilderWindow() {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(3, 2, 0, 0));

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		for (int i = 0; i < btnPoke.length; i++) {
			// btnPoke[i] = new JButton("Pokemon " + (i + 1));
			btnPoke[i] = new JButton("Click to add a Pokemon");

			panel.add(btnPoke[i]);
		}

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

	public void addListener(int index, ActionListener l) {
		btnPoke[index].addActionListener(l);
	}
}