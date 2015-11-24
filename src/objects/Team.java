package objects;

import com.pokejava.Pokemon;

public class Team {

	public static final int MAX_SIZE = 6;

	private Pokemon[] team = new Pokemon[MAX_SIZE];

	public Pokemon get(int i) {
		return team[i];
	}

	public void add(Pokemon p) {

		for (int i = 0; i < team.length; i++)
			if (team[i] == null) {
				team[i] = p;
				return;
			}

		throw new ArrayStoreException();

	}

	public Pokemon add(Pokemon p, int i) {
		Pokemon p2 = team[i];
		team[i] = p;
		return p2;
	}

	public void move(int currentIndex, int newIndex) {
		team[newIndex] = team[currentIndex];
		team[currentIndex] = null;
	}

	public void clear() {
		team = new Pokemon[MAX_SIZE];
	}

}
