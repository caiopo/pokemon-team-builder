package window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.pokejava.Pokemon;

import main.Main;
import objects.PokedexWrapper;

public class ViewPokedexWindow {

	private static final int NUM_COL = 4;

	private JFrame frame;
	private JPanel panel;
	private PokedexWrapper pokedex;

	public ViewPokedexWindow(PokedexWrapper pokedex) {
		this.pokedex = pokedex;

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, NUM_COL));

		List<String> pokemonNames = pokedex.getNames();

		for (int i = 0; i < PokedexWrapper.MAX_POKEDEX; i++) {

			JButton jb = new JButton((i + 1) + " - " + pokemonNames.get(i).substring(0, 1).toUpperCase()
					+ pokemonNames.get(i).substring(1));

			jb.addActionListener(new ViewPokedexListener(pokemonNames.get(i)));
			jb.setAlignmentX(Container.CENTER_ALIGNMENT);
			panel.add(jb);
		}

		JScrollPane jsp = new JScrollPane(panel);
		jsp.setPreferredSize(new Dimension(1000, 800));
		frame = new JFrame("Pokedex");

		frame.getContentPane().add(jsp);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void close() {

		frame.dispose();

		Main.showMainWindow();
	}

	class ViewPokedexListener implements ActionListener {
		private String pokeName;

		public ViewPokedexListener(String pokeName) {
			this.pokeName = pokeName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new PokemonInfoWindow(new Pokemon(pokeName));
		}

	}

}
