package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import objects.Team;

public class Exporter {

	public static void export(Team team, String url) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// pw.println("#TEAM");

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			if (team.get(i) == null)
				pw.println("null");
			else
				pw.println(team.get(i).getID());

		}

		pw.flush();
		pw.close();

	}

}
