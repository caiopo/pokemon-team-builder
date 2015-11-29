package window;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pokejava.Description;
import com.pokejava.Pokemon;

public class PokemonDescriptionWindow {

	private ArrayList<Description> descriptions;
	private int index = 0;
	private Pokemon pokemon;
	private JPanel panel;
	private JLabel label;
	private JButton close, next;
	private JFrame frame;

	public PokemonDescriptionWindow(Pokemon pokemon) {
		System.out.println("Creating: "+this.getClass().getName());

		this.pokemon = pokemon;

		descriptions = pokemon.getDescriptions();

		createWindow();

	}

	private void createWindow() {
		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		label = new JLabel();
		label.setIcon(pokemon.getIcon());
		label.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(label);

		next = new JButton("Next");
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		next.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(next);

		close = new JButton("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		close.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(close);

		frame = new JFrame(pokemon.getName());
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		next();
	}

	private void next() {

		label.setText(descriptions.get(index).getDescription());

		frame.setTitle(pokemon.getName() + " #" + (index + 1));

		index = (index + 1) % descriptions.size();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			frame.pack();
			frame.setLocationRelativeTo(null);
		}
	}

	private void dispose() {
		frame.dispose();
	}

}
