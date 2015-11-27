package objects;

import javax.swing.ImageIcon;

import com.pokejava.Pokemon;

public class TeamSlot {

	public Pokemon pokemon;
	public ImageIcon icon;

	public TeamSlot(Pokemon pokemon, ImageIcon icon) {

		this.pokemon = pokemon;
		this.icon = icon;
	}

}
