package window;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import io.Importer;
import objects.PokedexWrapper;
import objects.Team;

public class MainMenuWindow {

	private static final String TITLE = "Pokemon";

	private JFrame frame;
	private JPanel panel;
	private JButton newTeam, importTeam, viewPokedex;
	private PokedexWrapper pokedex;

	public MainMenuWindow(PokedexWrapper pokedex) {
		this.pokedex = pokedex;

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		newTeam = new JButton("Create a new Pokemon team");
		newTeam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewTeam();
			}
		});
		newTeam.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(newTeam);

		importTeam = new JButton("Import an existing Pokemon team");
		importTeam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importTeam();
			}
		});
		importTeam.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(importTeam);

		viewPokedex = new JButton("View Pokedex");
		viewPokedex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewPokedex();
			}
		});
		viewPokedex.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(viewPokedex);

		frame = new JFrame(TITLE);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void createNewTeam() {
		frame.setVisible(false);
		new TeamBuilderWindowManager(null, pokedex);
	}

	private void importTeam() {

		frame.setVisible(false);

		Team t = Importer.importar();

		if (t != null) {
			new TeamBuilderWindowManager(t, pokedex);
		} else {
			frame.setVisible(true);
		}
	}

	private void viewPokedex() {

		frame.setVisible(false);
		new ViewPokedexWindow(pokedex);

	}

	public void show() {
		frame.setVisible(true);
	}
}