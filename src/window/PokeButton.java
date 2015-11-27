package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.pokejava.Pokemon;

public class PokeButton extends JButton {

	public PokeButton(Pokemon pokemon) {
		super(pokemon.getName(), pokemon.getIcon());
	}

}

class PokeListener implements ActionListener {
	Pokemon pokemon;

	public PokeListener(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
