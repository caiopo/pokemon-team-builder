package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import objects.Team;
import util.PokedexWrapper;

public class TeamBuilderWindowManager {
	private Team team;
	private TeamBuilderWindow tbw;
	private PokedexWrapper pokedex;

	public TeamBuilderWindowManager(Team team, PokedexWrapper pokedex) {
		this.pokedex = pokedex;

		if (team != null)
			this.team = team;
		else
			this.team = new Team();

		tbw = new TeamBuilderWindow();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			tbw.addListener(i, new TeamBuilderListener(i));
		}

	}

	public void buttonPressed(int index) {

		if (team.get(index) == null) {
			team.add(PokemonSearch.open(pokedex), index);
			tbw.update(team);
		} else
			new PokemonInfoWindow(team.get(index));

	}

	class TeamBuilderListener implements ActionListener {
		private int index;

		public TeamBuilderListener(int index) {
			this.index = index;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			TeamBuilderWindowManager.this.buttonPressed(index);
		}

	}

}
