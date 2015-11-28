package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.pokejava.Pokemon;

import objects.Team;

public class Importer {

	public static Team importer(String url) {

		List<String> lines = null;

		try {

			lines = Files.readAllLines(Paths.get(url), StandardCharsets.UTF_8);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Team team = new Team();

		// for (int i = 0; i < lines.size(); i++) {

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			if (lines.get(i).equalsIgnoreCase("null"))
				team.add(null, i);
			else
				team.add(new Pokemon(Integer.parseInt(lines.get(i))), i);
			
		}

		return team;
	}

}
