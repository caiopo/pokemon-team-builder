package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.Exporter;
import objects.PokedexWrapper;
import objects.Team;
import window.PokemonInfoWindow;
import window.PokemonSearch;
import window.TeamBuilderWindow;

public class TeamBuilderWindowManager {
	private Team team;
	private TeamBuilderWindow tbw;
	private PokedexWrapper pokedex;

	public TeamBuilderWindowManager(Team team, PokedexWrapper pokedex) {
		this.pokedex = pokedex;

		tbw = new TeamBuilderWindow();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			tbw.addButtonListener(i, new TeamBuilderListener(i));
			tbw.addMenuItemListener(i, new RemoveListener(i));
		}

		if (team != null) {
			this.team = team;
			tbw.update(team);
		} else
			this.team = new Team();

		tbw.addExportListener(new ExportListener());

	}

	public void buttonPressed(int index) {

		if (team.get(index) == null) {
			team.add(PokemonSearch.open(pokedex), index);
			tbw.update(team);
		} else
			new PokemonInfoWindow(team.get(index));

	}

	public void pokemonRemoved(int index) {

		team.remove(index);
		tbw.update(team);

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

	class ExportListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Exporter.export(team);

		}

	}

	class RemoveListener implements ActionListener {
		private int index;

		public RemoveListener(int index) {
			this.index = index;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			TeamBuilderWindowManager.this.pokemonRemoved(index);
		}

	}

}
