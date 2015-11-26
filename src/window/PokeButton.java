package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pokejava.Pokemon;

public class PokeButton {

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
