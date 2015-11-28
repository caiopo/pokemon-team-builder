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
import javax.swing.JTextArea;

import com.pokejava.Description;
import com.pokejava.Pokemon;

public class PokemonDescriptionWindow {

	private ArrayList<Integer> descIDs;
	private int index = 0;
	private Description desc;
	// private ArrayList<Description> descs;
	private Pokemon pokemon;
	private JPanel panel;
	private JLabel label;
	private JButton close, next;
	private JFrame frame;

	public PokemonDescriptionWindow(Pokemon pokemon) {
		this.pokemon = pokemon;

		descIDs = pokemon.getDescriptionsID();

		desc = new Description(descIDs.get(0));

		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// panel.add(new JLabel(pokemon.getIcon()), Container.CENTER_ALIGNMENT);

		label = new JLabel(desc.getDescription());
		label.setIcon(pokemon.Icon);
		label.setAlignmentX(Container.CENTER_ALIGNMENT);
		panel.add(label);

		// JTextArea multi = new JTextArea(desc.getDescription());
		// multi.setWrapStyleWord(true);
		// multi.setLineWrap(true);
		// multi.setEditable(false);
		// panel.add(multi);

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
		frame.setResizable(false);
		frame.setVisible(true);

	}

	private void next() {

		index = (index + 1) % descIDs.size();

		desc = new Description(descIDs.get(index));

		label.setText(desc.getDescription());

		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	private void dispose() {
		frame.dispose();
	}
}
